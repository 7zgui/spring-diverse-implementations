package com.ecommerce.micrommerce.web.dao;

import com.ecommerce.micrommerce.model.Product;

import java.util.List;

/**
 * @author Mohamed ouokki on 11/10/22
 * @project micrommerce
 */
public interface ProductDao {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
}
