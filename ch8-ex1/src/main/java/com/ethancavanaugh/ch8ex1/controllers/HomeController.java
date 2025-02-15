package com.ethancavanaugh.ch8ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("username", "Ethan");
        model.addAttribute("color", "red");
        return "home.html";
    }
}
