package com.example.SecondHandShop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Cart {

    ArrayList<Product> customerItems;

    public Cart(ArrayList<Product> customerItems) {
        this.customerItems = new ArrayList<>();
    }

}
