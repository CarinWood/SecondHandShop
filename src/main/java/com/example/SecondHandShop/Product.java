package com.example.SecondHandShop;

import jakarta.persistence.*;

@Entity
public class Product {
    String name;
    String description;
    int price;
    String image;

    Long cathegory_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Product() {
    }

    public Product(String name, String description, int price, String image, Long cathegory_id, Long id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.cathegory_id = cathegory_id;
        this.id = id;
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

    public Long getCathegory() {
        return cathegory_id;
    }

    public void setCathegory(Long cathegory_id) {
        this.cathegory_id = cathegory_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
