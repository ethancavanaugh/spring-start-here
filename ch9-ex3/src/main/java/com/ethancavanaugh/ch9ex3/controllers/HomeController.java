package com.ethancavanaugh.ch9ex3.controllers;

import com.ethancavanaugh.ch9ex3.services.LoggedUserManagementService;
import com.ethancavanaugh.ch9ex3.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public HomeController(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(required=false) String logout,
                       Model model){
        //User clicked the log out link
        if(logout != null){
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        //Deny access to non-logged in users
        if(username == null){
            return "redirect:/login";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", loginCountService.getCount());
        return "home.html";
    }
}
