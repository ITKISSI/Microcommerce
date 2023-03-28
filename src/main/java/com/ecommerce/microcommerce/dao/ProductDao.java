package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    Product findById(int id);
    List<Product> findByPriceGreaterThan(int price);
    @Query("SELECT id, label, price FROM Product p WHERE p.price > :priceLimit")
    List<Product>  searchExpensive(@Param("priceLimit") int price);

}
