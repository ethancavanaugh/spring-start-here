package com.ethancavanaugh.ch9ex3.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Service
public class LoginCountService {
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
