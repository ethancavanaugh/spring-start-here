package com.ethancavanaugh.ch9ex3.model;

import com.ethancavanaugh.ch9ex3.services.LoggedUserManagementService;
import com.ethancavanaugh.ch9ex3.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login(){
        loginCountService.increment();

        boolean loginResult = false;
        if(username.equals("admin") && password.equals("admin")){
            loggedUserManagementService.setUsername(username);
            loginResult = true;
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
