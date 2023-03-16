package com.example.SecondHandShop;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cathegory {


    @OneToMany(mappedBy = "cathegory", cascade = CascadeType.ALL)
    private List<Product> product = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    public Cathegory() {
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // LEKSAKER, TEKNIK, KLÄDER, FORDON, HEM, SPORT
}
