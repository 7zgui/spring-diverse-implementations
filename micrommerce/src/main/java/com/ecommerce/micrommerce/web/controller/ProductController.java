package com.ecommerce.micrommerce.web.controller;

import com.ecommerce.micrommerce.model.Product;
import com.ecommerce.micrommerce.web.dao.ProductDao;
import com.ecommerce.micrommerce.web.exceptions.ProduitIntrouvableException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.logging.Filter;

/**
 * @author Mohamed ouokki on 11/8/22
 * @project micrommerce
 */
@RestController
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping("/Produits")
    public  MappingJacksonValue listeProduits() {
        Iterable<Product> products=productDao.findAll();
        SimpleBeanPropertyFilter myFilter= SimpleBeanPropertyFilter.serializeAllExcept("prixAchats");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productDynamicFilter",myFilter);
        MappingJacksonValue filteredProducts = new MappingJacksonValue(products);
        filteredProducts.setFilters(filters);
        return filteredProducts;
    }

    @GetMapping(value = "/Produits/{id}")
    public MappingJacksonValue afficherUnProduit(@PathVariable int id)
    {
        Product product = productDao.findById(id);
        if(product==null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
        SimpleBeanPropertyFilter myFilter=SimpleBeanPropertyFilter.serializeAllExcept("prixAchats");
        FilterProvider filtres = new SimpleFilterProvider().addFilter("productDynamicFilter",myFilter);
        MappingJacksonValue filteredProduct= new MappingJacksonValue(product);
        filteredProduct.setFilters(filtres);
        return filteredProduct;
    }

    @GetMapping(value = "test/Produits/{prixLimit}")
    public MappingJacksonValue testeDeRequetes(@PathVariable int prixLimit)
    {
        Iterable<Product> products = productDao.findByPrixGreaterThan(prixLimit);
        SimpleBeanPropertyFilter myFilter=SimpleBeanPropertyFilter.serializeAllExcept("prixAchats");
        FilterProvider filtres = new SimpleFilterProvider().addFilter("productDynamicFilter",myFilter);
        MappingJacksonValue filteredProducts= new MappingJacksonValue(products);
        filteredProducts.setFilters(filtres);
        return filteredProducts;
    }

    @PostMapping(value = "/Produit")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
        Product productCreated=productDao.save(product);
        if(productCreated !=null){
            return new ResponseEntity<Product>(HttpStatus.CREATED);
        }
        return null;
    }


}
