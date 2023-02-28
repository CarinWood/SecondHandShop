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

}