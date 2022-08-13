package com.example.plants.web;

import com.example.plants.model.DTO.OrderDTO;
import com.example.plants.model.entity.OrderEntity;
import com.example.plants.model.service.OrderServiceModel;
import com.example.plants.service.OrderService;
import com.example.plants.service.ShoppingCartService;
import com.example.plants.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderService orderService, ModelMapper modelMapper, ShoppingCartService shoppingCartService, UserService userService) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @GetMapping("/myCart/delivery")
    public String shoppingCartCheckout() {
        return "delivery";
    }

    @ModelAttribute
    public OrderDTO orderDTO() {
        return new OrderDTO();
    }


    @PostMapping("/myCart/delivery/placeOrder")
    public String confirmAddress(@Valid OrderDTO orderDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderDTO", bindingResult);
            return "redirect:/myCart/delivery/";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

         orderService.addOrder(auth, modelMapper.map(orderDTO, OrderServiceModel.class));


        shoppingCartService.clearProducts();
        return "redirect:/order/confirm/" + auth.getName();
    }

    @GetMapping("/order/confirm/{username}")
    public String order(@PathVariable String username, Model model) {
        model.addAttribute("orderConfirm", userService.findByUsername(username));

        return "order-confirm";
    }

    @GetMapping("/orders/all")
    public String all() {
        return "orders-all";
    }
}
