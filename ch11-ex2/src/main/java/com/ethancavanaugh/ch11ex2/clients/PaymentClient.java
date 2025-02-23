package com.ethancavanaugh.ch11ex2.clients;

import com.ethancavanaugh.ch11ex2.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentClient {
    private final RestTemplate restTemplate;
    private final String paymentServiceBaseUrl;

    public PaymentClient(RestTemplate restTemplate,
                         @Value("${payment-service.url}") String paymentServiceBaseUrl){
        this.restTemplate = restTemplate;
        this.paymentServiceBaseUrl = paymentServiceBaseUrl;
    }

    public Payment createPayment(Payment payment){
        String uri = paymentServiceBaseUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> response =
                restTemplate.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        Payment.class);
        return response.getBody();
    }
}
