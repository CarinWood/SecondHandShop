package com.example.SecondHandShop;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import java.util.ArrayList;
@Service
public class ProductRepository {

    ArrayList<Product> products;







    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(Long id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // här sker buggen som skedde under demo - denna kollar inte om det nya id:t är upptaget
    public int createNewId() {
        return products.size();
    }


    public void removeById(Long id) {
        Product removeProduct = null;
        for(Product product: products) {
            if(product.getId() == id) {
                removeProduct = product;
            }
        }
        if(removeProduct != null) {
            products.remove(removeProduct);
        }
    }
}


