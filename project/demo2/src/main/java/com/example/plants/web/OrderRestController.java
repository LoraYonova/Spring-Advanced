package com.example.plants.web;

import com.example.plants.model.view.OrderViewModel;
import com.example.plants.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all/api")
    public ResponseEntity<List<OrderViewModel>> getAllOrders() {
        List<OrderViewModel> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }


}
