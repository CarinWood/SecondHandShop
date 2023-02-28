package com.example.SecondHandShop;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class ProductRepository {

    ArrayList<Product> products;

    ArrayList<Product> customerItems;


    public ProductRepository() {

        this.customerItems = new ArrayList<>();

        this.products = new ArrayList<>();
        products.add(new Product("My little pony", "Fin häst från 80-talet! Mycket gott skick! Mint condition", 100, "/images/pony.jpg", Cathegory.LEKSAKER, 1));
        products.add(new Product("Gibson les Paul", "Fantastisk gitarr från 70-talet! Några få skador. Pris kan diskuteras", 9000, "/images/gitarr.jpg", Cathegory.TEKNIK, 2));
        products.add(new Product("Mizuno JPX921", "4-pw. Har hjälpt mig gå från 54 till 50 i HCP! Lite för svåra för mig, därav säljer jag dem", 8000, "/images/golf.jpg", Cathegory.SPORT, 3));
        products.add(new Product("Symaskinsbord", "Underrede till symaskin med grå träskiva. Bredd 80 cm Djup 50 cm Höjd 75 cm", 500, "/images/symaskin.png", Cathegory.HEM, 4));
        products.add(new Product("Skinnjacka", "Fint skick, ingen defekt. svart med silverdetaljer. Storlek 36", 450, "/images/jacka.jpg", Cathegory.KLÄDER, 5));
        products.add(new Product("Yamaha DT", "Årsmodell 1997, gått 1200 mil", 10000, "/images/moped.png", Cathegory.FORDON, 6));

    }




    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(int id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }



}


