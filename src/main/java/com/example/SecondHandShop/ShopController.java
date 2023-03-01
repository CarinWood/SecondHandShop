package com.example.SecondHandShop;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@Controller
public class ShopController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    Cart cart;
    Cathegory cathegory;
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
        System.out.println(productRepository.getProducts());
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

        model.addAttribute("cartArray", cart.getItems());
        model.addAttribute("cartSize", cart.getItems().size());


        return "checkout";

    }

    @GetMapping("/nicetohave/newpost")
    String newpost(Model model) {
        model.addAttribute("cathegory", Cathegory.values());
        System.out.println(Cathegory.values());

        return "newpost";
    }

    @PostMapping("/nicetohave/newpost")
    String newpostpost(Model model, @RequestParam String name, String description, int price, String image, String cathegory) {
        Cathegory c = Cathegory.valueOf(cathegory);
        productRepository.products.add(new Product(name, description, price, image, c, productRepository.createNewId()));
        System.out.println(productRepository.getProducts());
        return "newpost";
    }



}
