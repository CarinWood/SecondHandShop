package com.example.SecondHandShop;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

//HEJ HEJ
@Controller
public class ShopController {


    @Autowired
    ProductRepo productRepository;

    @Autowired
    Cart cart;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CathegoryRepo cathegoryRepo;

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/nicetohave")
    String ShopFunc(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("cartSize", cart.getItems().size());
        model.addAttribute("cartArray", cart.getItems());
        model.addAttribute("sum", cart.getSum());
        return "shop";
    }

    @GetMapping("/nicetohave/cat/{id}")
    String shopFunctionHem(Model model, @PathVariable Long id) {
        model.addAttribute("products", productRepository.findByCathegoryId(id));
        model.addAttribute("cartSize", cart.getItems().size());
        model.addAttribute("cartArray", cart.getItems());
        model.addAttribute("sum", cart.getSum());
        return "hem";
    }

    @GetMapping("/nicetohave/delete/{id}")
    String shopPostFunc(@PathVariable Long id) {
        cart.removeById(id);
        System.out.println(cart.getItems());
        return "redirect:/nicetohave";
    }

    @GetMapping("/nicetohave/paymentconfirmed")
    String payment() {
        ArrayList<Product> copy = new ArrayList<>();
        for (Product product : cart.getItems()) {
            for (Product p : productRepository.findAll()) {
                if (product.getId() == p.getId()) {
                    copy.add(product);
                }
            }
        }
        for (Product sak : copy) {
            productRepository.deleteById(sak.getId());
            cart.removeById(sak.getId());
        }
        return "paymentconfirmed";
    }

    @PostMapping("/nicetohave/{id}")
    String postFunc(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", productRepository.findById(id).get());
        cart.getItems().add(productRepository.findById(id).get());
        model.addAttribute("cartArray", cart.getItems().size());
        model.addAttribute("cartList", cart.getItems());
        model.addAttribute("sum", cart.getSum());
        return "product";
    }

    @GetMapping("/nicetohave/{id}")
    String getProductFunc(Model model, @PathVariable Long id) {
        model.addAttribute("product", productRepository.findById(id).get());
        model.addAttribute("cartArray", cart.getItems().size());
        return "product";
    }


    @GetMapping("/nicetohave/checkout")
    String checkoutFunc(Model model) {
        model.addAttribute("cartArray", cart.getItems());
        model.addAttribute("cartSize", cart.getItems().size());
        model.addAttribute("sum", cart.getSum());

        return "checkout";

    }

    @GetMapping("/nicetohave/newpost")
    String newpost(Model model) {
        model.addAttribute("cathegory", cathegoryRepo.findAll());
        return "newpost";
    }

    @PostMapping("/nicetohave/newpost")
    String newpostpost(Model model, @RequestParam String name, String description, int price, String image, Long cathegory) {
        Cathegory c = cathegoryRepo.findById(cathegory).get();
        Product product = new Product(name, description, price, image, c);
        productRepository.save(product);
        System.out.println(product);
        System.out.println(productRepository.findAll());
        return "newpost";

    }

    //hej

    @GetMapping("/nicetohave/register")
    String registerFunc() {
        return "register";
    }

    @GetMapping("/nicetohave/login")
    String login() {
        return "login";
    }

    @PostMapping("/nicetohave/login")
    String loginPost(Model model, @RequestParam String username, @RequestParam String password) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        Account account = accountRepo.findByUsernameAndPassword(username, password);
        if (account != null) {
            return "redirect:/nicetohave/userpage/" + account.id;
        }
        System.out.println(username);
        System.out.println(accountRepo.findAll());
        return "redirect:/nicetohave/login";
    }


    @GetMapping("/nicetohave/userpage/{userId}")
    String userpageFunc(Model model, @PathVariable Long userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("user", accountRepo.findById(userId).get().username);
        return "userpage";
    }


    @PostMapping("/nicetohave/register")
    String postregisterfunc(Model model, @RequestParam String password, @RequestParam String username) {
        Account newAccount = new Account(username, password);
        Account account = accountRepo.findByUsername(username);
        if(account != null){
            return "failed";
        }
        accountRepo.save(newAccount);
        return "redirect:/nicetohave/login";
    }


    @GetMapping("/nicetohave/failed")
    String failedFunc() {
        return "failed";
    }
}





