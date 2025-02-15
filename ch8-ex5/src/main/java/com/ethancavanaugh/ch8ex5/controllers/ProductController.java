package com.ethancavanaugh.ch8ex5.controllers;

import com.ethancavanaugh.ch8ex5.model.Product;
import com.ethancavanaugh.ch8ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
    @PostMapping("/products")
    //Automatically binds form data to Product object; can also be done manually with @RequestParam
    public String addProduct(@ModelAttribute Product p, Model model){
        productService.addProduct(p);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
