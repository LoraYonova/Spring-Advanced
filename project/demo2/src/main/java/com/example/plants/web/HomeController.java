package com.example.plants.web;

import com.example.plants.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mostExpensiveProducts", this.productService.getMostExpensiveProduct());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }




}
