package com.example.SecondHandShop;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
public class Cathegory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Cathegory() {
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
