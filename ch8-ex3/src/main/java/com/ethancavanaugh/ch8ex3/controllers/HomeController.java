package com.ethancavanaugh.ch8ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @RequestMapping("/home/{color}")
    public String home(@PathVariable(required = false) Optional<String> color,
                       Model model) {
        model.addAttribute("username", "Ethan");
        model.addAttribute("color", color.orElse("black"));
        return "home.html";
    }
}
