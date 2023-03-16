package com.example.SecondHandShop;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import java.util.ArrayList;
@Service
public class ProductRepository {

    ArrayList<Product> products;


    /*public ProductRepository() {

        this.products = new ArrayList<>();
        products.add(new Product("My little pony", "Fin häst från 80-talet! Mycket gott skick! Mint condition", 100, "/images/pony.jpg", Cathegory.LEKSAKER, createNewId()));
        products.add(new Product("Gibson les Paul", "Fantastisk gitarr från 70-talet! Några få skador. Pris kan diskuteras", 9000, "/images/gitarr.jpg", Cathegory.TEKNIK, createNewId()));
        products.add(new Product("Mizuno JPX921", "4-pw. Har hjälpt mig gå från 54 till 50 i HCP! Lite för svåra för mig, därav säljer jag dem", 8000, "/images/golf.jpg", Cathegory.SPORT, createNewId()));
        products.add(new Product("Symaskinsbord", "Underrede till symaskin med grå träskiva. Bredd 80 cm Djup 50 cm Höjd 75 cm", 500, "/images/symaskin.png", Cathegory.HEM, createNewId()));
        products.add(new Product("Skinnjacka", "Fint skick, ingen defekt. svart med silverdetaljer. Storlek 36", 450, "/images/jacka.jpg", Cathegory.KLÄDER, createNewId()));
        products.add(new Product("Yamaha DT", "Årsmodell 1997, gått 1200 mil", 10000, "/images/moped.png", Cathegory.FORDON, createNewId()));
        products.add(new Product("Biljardbord", "Säljer detta fina bord med lite fläckar på. Pris kan diskuteras", 5000, "/images/biljardbord.png", Cathegory.SPORT, createNewId()));
        products.add(new Product("Gul Klänning", "Omtalad klänning, lite för gul för min smak.", 150, "/images/dress.png", Cathegory.KLÄDER, createNewId()));
        products.add(new Product("Settlers of Catan", "Mycket roligt spel, funkar för de flesta åldrar!", 400, "/images/catan.png", Cathegory.LEKSAKER, createNewId()));
        products.add(new Product("Pokémonkort", "Väldigt exklusivt kort som har fått sig några kyssar i flyttar.", 40000, "/images/Charizard.png", Cathegory.LEKSAKER, createNewId()));
        products.add(new Product("Röd jacka", "Fin jacka som blivit för liten för mig.", 600, "/images/Jacka röd.png", Cathegory.KLÄDER, createNewId()));
        products.add(new Product("Padelrack", "Mycket fint padelrack, säljer då jag blivit för bra och vill testa något nytt.", 1200, "/images/padelrack.png", Cathegory.SPORT, createNewId()));
        products.add(new Product("Barnskidor, Head", "Säljer dessa underbara skidor som mitt barn haft mycket nöje för. Passar bäst för längden 140-160cm", 800, "/images/skidor.png", Cathegory.SPORT, createNewId()));

    }*/




    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(Long id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // här sker buggen som skedde under demo - denna kollar inte om det nya id:t är upptaget
    public int createNewId() {
        return products.size();
    }


    public void removeById(Long id) {
        Product removeProduct = null;
        for(Product product: products) {
            if(product.getId() == id) {
                removeProduct = product;
            }
        }
        if(removeProduct != null) {
            products.remove(removeProduct);
        }
    }
}


