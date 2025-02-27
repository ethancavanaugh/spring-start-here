package com.ethancavanaugh.ch12ex2.controllers;

import com.ethancavanaugh.ch12ex2.model.Purchase;
import com.ethancavanaugh.ch12ex2.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
    private PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/purchase")
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    @PostMapping("/purchase")
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        int id = purchaseRepository.save(purchase);
        purchase.setId(id);
        return purchase;
    }
}
