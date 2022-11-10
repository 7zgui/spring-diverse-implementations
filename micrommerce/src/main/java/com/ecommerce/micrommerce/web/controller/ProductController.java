package com.ecommerce.micrommerce.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohamed ouokki on 11/8/22
 * @project micrommerce
 */
@RestController
public class ProductController {

    @GetMapping("/Produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }

    @GetMapping("/Produits/{id}")
    public String afficherUnProduit(@PathVariable int id) {
        return "Vous avez demandé un produit avec l'id  " + id;
    }
}
