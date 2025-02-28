package com.ethancavanaugh.ch13ex1.services;

import com.ethancavanaugh.ch13ex1.dto.TransferRequest;
import com.ethancavanaugh.ch13ex1.model.Account;
import com.ethancavanaugh.ch13ex1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private AccountRepository acctRepository;

    public TransferService(AccountRepository accountRepository) {
        this.acctRepository = accountRepository;
    }

    public void transferMoney(TransferRequest request) {
        long senderAcctId = request.getSenderAccountId();
        long receiverAcctId = request.getReceiverAccountId();
        BigDecimal transferAmount = request.getTransferAmount();

        if (senderAcctId == receiverAcctId){
            return;
        }

        Account senderAcct = acctRepository.findById(senderAcctId);
        Account receiverAcct = acctRepository.findById(receiverAcctId);

        acctRepository.setBalance(senderAcctId,
                senderAcct.getBalance().subtract(transferAmount));
        acctRepository.setBalance(receiverAcctId,
                receiverAcct.getBalance().add(transferAmount));
        //throw new RuntimeException();
    }

    public List<Account> getAllAccounts(){
        return acctRepository.findAll();
    }
}
