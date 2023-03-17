package com.example.SecondHandShop;

import jakarta.persistence.*;

@Entity
public class Product {
    String name;
    String description;
    int price;
    String image;
    @ManyToOne
    Cathegory cathegory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Product() {
    }

    public Product(String name, String description, int price, String image, Cathegory cathegory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.cathegory = cathegory;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
