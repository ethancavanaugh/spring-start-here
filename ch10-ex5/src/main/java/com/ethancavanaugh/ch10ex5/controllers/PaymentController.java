package com.ethancavanaugh.ch10ex5.controllers;

import com.ethancavanaugh.ch10ex5.exceptions.InsufficientFundsException;
import com.ethancavanaugh.ch10ex5.model.PaymentDetails;
import com.ethancavanaugh.ch10ex5.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<Object> makePayment(){
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (InsufficientFundsException e){
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

}
