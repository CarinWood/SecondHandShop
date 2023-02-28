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
        model.addAttribute("cartSize", cart.getItems().size());
        model.addAttribute("cartArray", cart.getItems());
        model.addAttribute("sum", cart.getSum());

        return "shop";
    }

    @PostMapping("/nicetohave/{id}")
    String postFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        cart.getItems().add(productRepository.getProduct(id));
        System.out.println(cart.getItems());
        model.addAttribute("cartArray", cart.getItems().size());
        return "product";
    }

    @GetMapping("/nicetohave/{id}")
    String getProductFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        model.addAttribute("cartArray", cart.getItems().size());

        return "product";
    }

    @GetMapping("/nicetohave/checkout")
    String checkoutFunc(Model model) {

        model.addAttribute("", cart.getItems());
        model.addAttribute("cartSize", cart.getItems().size());

        return "checkout";

    }



}
