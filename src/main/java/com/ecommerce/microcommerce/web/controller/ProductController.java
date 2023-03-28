package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.Model.Product;
import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return  productDao.findAll();
    }
    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") final int id)
    {
        return productDao.findById(id);
    }
    @PostMapping(value = "/Products")
    public void addProduct(@RequestBody Product product) {
        productDao.save(product);
    }
}
