package com.example.SecondHandShop;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
@Service
@SessionScope
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ArrayList<Product> customerItems = new ArrayList<>();

   public Cart() {

    }


    public ArrayList<Product> getItems() {

       return customerItems;
    }

    public Product getProduct(Long id) {
       for(Product product: customerItems) {
           if(product.getId() == id) {
               return product;
           }
       }
       return null;
    }

    public int getSum() {
       int sum = 0;
       for(Product product: customerItems) {
           sum += product.price;
       }

       return sum;
    }

    public void removeById(Long id) {
       Product removeProduct = null;
       for(Product product: customerItems) {
           if(product.getId() == id) {
               removeProduct = product;
           }
       }
       if(removeProduct != null) {
           customerItems.remove(removeProduct);
       }

    }

}
