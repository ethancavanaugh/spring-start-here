package com.ethancavanaugh.ch10ex3.controllers;

import com.ethancavanaugh.ch10ex3.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/all")
    public List<Country> allCountries(){
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 69);
        return List.of(c1, c2);
    }

    @GetMapping("/france")
    public Country france(){
        return Country.of("France", 67);
    }
}
