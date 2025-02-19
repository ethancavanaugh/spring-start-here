package com.ethancavanaugh.ch10ex5.services;

import com.ethancavanaugh.ch10ex5.exceptions.InsufficientFundsException;
import com.ethancavanaugh.ch10ex5.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new InsufficientFundsException("Insufficient Funds");
    }
}
