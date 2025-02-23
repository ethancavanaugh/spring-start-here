package com.ethancavanaugh.ch11ex1.controllers;

import com.ethancavanaugh.ch11ex1.clients.PaymentClient;
import com.ethancavanaugh.ch11ex1.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentClient paymentClient;

    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String requestId = UUID.randomUUID().toString();

        return paymentClient.createPayment(requestId, payment);
    }
}
