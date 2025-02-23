package com.ethancavanaugh.ch11ex1.clients;

import com.ethancavanaugh.ch11ex1.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name="payment", url = "${payment-service.url}")
public interface PaymentClient {
    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}
