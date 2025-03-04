package com.ethancavanaugh.ch15ex1.services;

import com.ethancavanaugh.ch15ex1.dto.TransferRequest;
import com.ethancavanaugh.ch15ex1.model.Account;
import com.ethancavanaugh.ch15ex1.repositories.AccountRepository;
import com.ethancavanaugh.ch15ex1.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final AccountRepository acctRepository;

    public TransferService(AccountRepository accountRepository) {
        this.acctRepository = accountRepository;
    }

    public void transferMoney(long senderAcctId, long receiverAcctId, BigDecimal transferAmount) {
        if (senderAcctId == receiverAcctId){
            return;
        }

        Account senderAcct = acctRepository.findById(senderAcctId).orElseThrow(AccountNotFoundException::new);
        Account receiverAcct = acctRepository.findById(receiverAcctId).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewBalance = senderAcct.getBalance().subtract(transferAmount);
        BigDecimal receiverNewBalance = receiverAcct.getBalance().add(transferAmount);

        acctRepository.setBalance(senderAcctId, senderNewBalance);
        acctRepository.setBalance(receiverAcctId, receiverNewBalance);
    }

    public List<Account> getAllAccounts(){
        return acctRepository.findAll();
    }

    public List<Account> findAccountsByName(String name){
        return acctRepository.findAccountsByName(name);
    }


}
