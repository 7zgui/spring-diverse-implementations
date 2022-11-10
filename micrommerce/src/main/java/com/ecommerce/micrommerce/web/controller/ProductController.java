package com.ecommerce.micrommerce.web.controller;

import com.ecommerce.micrommerce.model.Product;
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

    //Récupérer un produit par son Id
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        Product product ;
        return product= new Product(id, new String("Aspirateur"), 100);
    }
}
