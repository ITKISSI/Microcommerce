package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.Model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(final int id);
    Product save(Product product);
}
