package com.ethancavanaugh.ch11ex3.clients;

import com.ethancavanaugh.ch11ex3.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class PaymentClient {
    private final WebClient webClient;
    private final String paymentServiceBaseUrl;

    public PaymentClient(WebClient webClient,
                         @Value("${payment-service.url}") String paymentServiceBaseUrl){
        this.webClient = webClient;
        this.paymentServiceBaseUrl = paymentServiceBaseUrl;
    }

    public Mono<Payment> createPayment(Payment payment){

        return webClient.post()
                .uri(paymentServiceBaseUrl + "/payment")
                .header("requestId", UUID.randomUUID().toString())
                .body(Mono.just(payment), Payment.class)
                .retrieve().bodyToMono(Payment.class);
    }
}
