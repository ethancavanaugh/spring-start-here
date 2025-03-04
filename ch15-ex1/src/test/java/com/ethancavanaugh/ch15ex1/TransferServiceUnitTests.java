package com.ethancavanaugh.ch15ex1;

import com.ethancavanaugh.ch15ex1.exceptions.AccountNotFoundException;
import com.ethancavanaugh.ch15ex1.model.Account;
import com.ethancavanaugh.ch15ex1.repositories.AccountRepository;
import com.ethancavanaugh.ch15ex1.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {
    @Mock
    private AccountRepository acctRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    @DisplayName("Under normal conditions, the correct amount should be transferred.")
    public void successfulTransfer() {
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

    @Test
    @DisplayName("When account does not exist, AccountNotFound exception should be thrown and no money transferred.")
    public void accountNotFound() {
        Account senderAcct = new Account();
        senderAcct.setId(1);
        senderAcct.setBalance(new BigDecimal(1000));

        when(acctRepository.findById(1L))
                .thenReturn(Optional.of(senderAcct));
        when(acctRepository.findById(2L))
                .thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () ->
                transferService.transferMoney(1, 2, new BigDecimal(100))
        );
        verify(acctRepository, never())
                .setBalance(anyLong(), any());
    }
}
