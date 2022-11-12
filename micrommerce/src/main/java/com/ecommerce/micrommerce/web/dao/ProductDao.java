package com.ecommerce.micrommerce.web.dao;

import com.ecommerce.micrommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mohamed ouokki on 11/10/22
 * @project micrommerce
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    Product findById(int id);
}
