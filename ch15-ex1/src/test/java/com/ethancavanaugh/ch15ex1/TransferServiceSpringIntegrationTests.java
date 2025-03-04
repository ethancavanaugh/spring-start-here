package com.ethancavanaugh.ch15ex1;

import com.ethancavanaugh.ch15ex1.model.Account;
import com.ethancavanaugh.ch15ex1.repositories.AccountRepository;
import com.ethancavanaugh.ch15ex1.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {
    @MockitoBean
    private AccountRepository acctRepository;

    @Autowired
    private TransferService transferService;

    @Test
    @DisplayName("Under normal conditions and integrated w/ Spring, the correct amount should be transferred.")
    public void successfulTransfer(){
        Account senderAcct = new Account();
        senderAcct.setId(1);
        senderAcct.setBalance(new BigDecimal(1000));

        Account receiverAcct = new Account();
        receiverAcct.setId(2);
        receiverAcct.setBalance(new BigDecimal(1000));

        when(acctRepository.findById(senderAcct.getId()))
                .thenReturn(Optional.of(senderAcct));
        when(acctRepository.findById(receiverAcct.getId()))
                .thenReturn(Optional.of(receiverAcct));

        transferService.transferMoney(
                senderAcct.getId(),
                receiverAcct.getId(),
                new BigDecimal(100)
        );

        verify(acctRepository).setBalance(senderAcct.getId(), new BigDecimal(900));
        verify(acctRepository).setBalance(receiverAcct.getId(), new BigDecimal(1100));
    }
}
