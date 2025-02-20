package com.ethancavanaugh.ch10ex6.services;

import com.ethancavanaugh.ch10ex6.exceptions.InsufficientFundsException;
import com.ethancavanaugh.ch10ex6.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new InsufficientFundsException("Insufficient Funds");
    }
}
