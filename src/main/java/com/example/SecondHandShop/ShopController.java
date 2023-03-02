package com.example.SecondHandShop;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

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

    @GetMapping("/nicetohave/delete/{id}")
    String shopPostFunc(@PathVariable int id) {
        cart.removeById(id);
        System.out.println(cart.getItems());
        return "redirect:/nicetohave";
    }

    @GetMapping("/nicetohave/paymentconfirmed")
    String payment() {
        ArrayList<Product> copy = new ArrayList<>();
        for(Product product : cart.getItems()) {
            for (Product p : productRepository.products) {
                if (product.getId() == p.getId()) {
                    copy.add(product);
                }
            }
        }
        for(Product sak : copy) {
            productRepository.removeById(sak.getId());
            cart.removeById(sak.getId());
        }
        return "paymentconfirmed";
    }
    @PostMapping("/nicetohave/{id}")
    String postFunc(Model model, @PathVariable int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        cart.getItems().add(productRepository.getProduct(id));
        model.addAttribute("cartArray", cart.getItems().size());
        model.addAttribute("cartList", cart.getItems());
        model.addAttribute("sum", cart.getSum());
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
        return "newpost";
    }

    @PostMapping("/nicetohave/newpost")
    String newpostpost(Model model, @RequestParam String name, String description, int price, String image, String cathegory) {
        Cathegory c = Cathegory.valueOf(cathegory);
        productRepository.products.add(new Product(name, description, price, image, c, productRepository.createNewId()));
        return "newpost";
    }




}
