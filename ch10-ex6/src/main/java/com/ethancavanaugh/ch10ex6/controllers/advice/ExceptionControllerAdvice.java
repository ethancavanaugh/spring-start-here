package com.ethancavanaugh.ch10ex6.controllers.advice;

import com.ethancavanaugh.ch10ex6.controllers.PaymentController;
import com.ethancavanaugh.ch10ex6.exceptions.InsufficientFundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<String> insufficientFundsHandler(InsufficientFundsException e){
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
