package com.example.SecondHandShop;

public class Product {
    String name;
    String description;
    int price;
    String image;
    String cathegory;

    public Product(String name, String description, int price, String image, String cathegory) {
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

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }
}
