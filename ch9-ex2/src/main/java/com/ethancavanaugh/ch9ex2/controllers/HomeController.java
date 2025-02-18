package com.ethancavanaugh.ch9ex2.controllers;

import com.ethancavanaugh.ch9ex2.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final LoggedUserManagementService loggedUserManagementService;

    public HomeController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
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
        return "home.html";
    }
}
