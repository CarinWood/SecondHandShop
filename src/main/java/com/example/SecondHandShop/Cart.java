package com.example.SecondHandShop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

@Service
@SessionScope
public class Cart {


    private ArrayList<Product> customerItems = new ArrayList<>();

   public Cart() {
//        this.customerItems = new ArrayList<>();
    }


    public ArrayList<Product> getItems() {

       return customerItems;
    }

    public Product getProduct(int id) {
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

    public void removeById(int id) {
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
