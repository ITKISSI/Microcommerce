package com.ecommerce.microcommerce.Model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@JsonFilter("myDynamicFilter")
@Entity
public class Product {
    @Id
    private int id;
    private String label;
    private int price;
    //@JsonIgnoreProperties(value = {"originalPrice", "id"})
    //@JsonIgnore

    private int originalPrice;

    public Product() {
    }

    public Product(int id, String label, int price,int originalPrice) {

        this.id = id;

        this.label = label;

        this.price = price;
        this.originalPrice=originalPrice;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public int getoriginalPrice() {
        return originalPrice;
    }

    public void setoriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
