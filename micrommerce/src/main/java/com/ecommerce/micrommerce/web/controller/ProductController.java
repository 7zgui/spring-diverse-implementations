package com.ecommerce.micrommerce.web.controller;

import com.ecommerce.micrommerce.model.Product;
import com.ecommerce.micrommerce.web.dao.ProductDao;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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


}
