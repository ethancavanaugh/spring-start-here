package com.ethancavanaugh.ch9ex1.controllers;

import com.ethancavanaugh.ch9ex1.model.LoginProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            model.addAttribute("loginMessage", "Login Successful!");
        }
        else{
            model.addAttribute("loginMessage", "Login Failed :(");
        }
        return "login.html";
    }
}
