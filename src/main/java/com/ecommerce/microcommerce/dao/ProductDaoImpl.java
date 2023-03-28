package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductDaoImpl implements ProductDao{
    static List<Product> products = new ArrayList<>(100);

    static{
        products.add(new Product(1,"samsung",3000));
        products.add(new Product(2,"LG",2000));
        products.add(new Product(3,"Iphone",5000));
        products.add(new Product(4,"Blackberry",1000));
    }




    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for(Product p:products)
        {
            if(p.getId()==id)
                return p;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
