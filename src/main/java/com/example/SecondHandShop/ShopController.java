package com.example.SecondHandShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {


    @Autowired
    ProductRepository productRepository;
    Cart cart;
    @GetMapping("/nicetohave")
    String ShopFunc(Model model) {
        model.addAttribute("products", productRepository.getProducts());

        return "shop";
    }

    @PostMapping("/nicetohave/{id}")
    String postFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        cart.customerItems.add(productRepository.getProduct(id));
        System.out.println(cart.customerItems);
        return "product";
    }

    @GetMapping("/nicetohave/{id}")
    String getProductFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));

        return "product";
    }



}
