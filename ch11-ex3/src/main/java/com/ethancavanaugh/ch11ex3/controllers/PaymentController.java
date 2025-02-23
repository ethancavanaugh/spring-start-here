package com.ethancavanaugh.ch11ex3.controllers;

import com.ethancavanaugh.ch11ex3.clients.PaymentClient;
import com.ethancavanaugh.ch11ex3.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController {
    private final PaymentClient paymentClient;

    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment){
        return paymentClient.createPayment(payment);
    }
}
