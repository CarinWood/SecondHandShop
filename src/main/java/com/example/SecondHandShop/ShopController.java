package com.example.SecondHandShop;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

@Controller
public class ShopController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    Cart cart;
    @GetMapping("/nicetohave")
    String ShopFunc(Model model) {
        model.addAttribute("products", productRepository.getProducts());
        model.addAttribute("cartArray", cart.getItems().size());

        return "shop";
    }

    @PostMapping("/nicetohave/{id}")
    String postFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        cart.getItems().add(productRepository.getProduct(id));
        System.out.println(cart.getItems());
        return "product";
    }

    @GetMapping("/nicetohave/{id}")
    String getProductFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        //session.setAttribute("productId", id);

        return "product";
    }



}
