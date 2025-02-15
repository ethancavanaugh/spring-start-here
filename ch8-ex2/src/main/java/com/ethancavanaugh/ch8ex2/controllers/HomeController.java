package com.ethancavanaugh.ch8ex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(@RequestParam(defaultValue="black") String color,
                       @RequestParam(required=false) String username,
                       Model model) {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "home.html";
    }
}
