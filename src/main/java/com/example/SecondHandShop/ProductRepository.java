package com.example.SecondHandShop;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class ProductRepository {

    ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(int id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}


