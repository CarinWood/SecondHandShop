package com.example.SecondHandShop;

public class Product {
    String name;
    String description;
    int price;
    String image;
    Cathegory cathegory;
    int id;

    public Product(String name, String description, int price, String image, Cathegory cathegory, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.cathegory = cathegory;
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

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
