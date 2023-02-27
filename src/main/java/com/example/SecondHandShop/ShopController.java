package com.example.SecondHandShop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {



    @GetMapping("/nicetohave")
    String ShopFunc() {
        return "shop";
    }
}
