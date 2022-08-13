package com.example.plants.web;

import com.example.plants.model.DTO.OrderDTO;
import com.example.plants.model.entity.ProductEntity;
import com.example.plants.service.OrderService;
import com.example.plants.service.ProductService;
import com.example.plants.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final OrderService orderService;


    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/myCart")
    public String myCart(Model model) {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("totalSum", shoppingCartService.totalSum());

        return "shopping-cart";
    }

    @GetMapping("/myCart/add/{id}")
    public String addProductInShoppingCart(@PathVariable Long id) {
        ProductEntity productEntity = productService.findById(id);

        if (productEntity != null) {
            shoppingCartService.addProduct(productEntity);
        }

        return "redirect:/";
    }

    @GetMapping("/myCart/remove/{id}")
    public String removeProductFromShoppingCart(@PathVariable Long id) {
        ProductEntity productEntity = productService.findById(id);

        if (productEntity != null) {
            shoppingCartService.removeProduct(productEntity);
        }

        return "redirect:/myCart";
     }

     @GetMapping("/myCart/clear")
    public String clearProductsInShoppingCart() {
        shoppingCartService.clearProducts();

        return "redirect:/myCart";
     }



     @GetMapping("/myCart/delivery/goBack")
    public String goBackToShoppingCart() {
        return "redirect:/myCart";
     }



}
