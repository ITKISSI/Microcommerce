package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.Model.Product;
import com.ecommerce.microcommerce.dao.ProductDao;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;


@RestController
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public MappingJacksonValue getProducts()
    {
        List<Product> products = productDao.findAll();
        //make filter on originalPrice ==> not to show
        SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("originalPrice");
        // the filter is applicable on all the beans annotated with myDynamicFilter
        FilterProvider ourFilters = new SimpleFilterProvider().addFilter("myDynamicFilter",myFilter);
        // access the methods setFilter()... that we'll apply on our Products list
        MappingJacksonValue productsFilter = new MappingJacksonValue(products);
        productsFilter.setFilters(ourFilters);
        return  productsFilter;
    }
    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") final int id)
    {
        return productDao.findById(id);
    }
    @GetMapping("productPriceMore/{price}")
    public List<Product> getProductPriceMore(@PathVariable("price") final int price)
    {
        return productDao.findByPriceGreaterThan(price);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        Product addedProduct=productDao.save(product);
        if(Objects.isNull((addedProduct)))
        {
            ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(addedProduct.getId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value="/product/{id}")
    public void deleteProduct(@PathVariable("id") int id)
    {
        productDao.delete(productDao.findById(id));
    }
    @GetMapping("/searchExpensive/{price}")
    public List<Product> searchExpensive(@PathVariable("price") int price)
    {
        return productDao.searchExpensive(price);
    }
}
