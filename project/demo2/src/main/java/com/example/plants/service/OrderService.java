package com.example.plants.service;

import com.example.plants.model.entity.OrderEntity;
import com.example.plants.model.service.OrderServiceModel;
import com.example.plants.model.view.OrderViewModel;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderService {

    void addOrder(Authentication auth, OrderServiceModel orderServiceModel);

    List<OrderViewModel> getAllOrders();
}
