package com.ethancavanaugh.ch15ex1.controllers;

import com.ethancavanaugh.ch15ex1.model.Account;
import com.ethancavanaugh.ch15ex1.dto.TransferRequest;
import com.ethancavanaugh.ch15ex1.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getTransferAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(@RequestParam(required=false) String name){
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
