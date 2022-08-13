package com.example.plants.service.impl;
import com.example.plants.model.entity.OrderEntity;
import com.example.plants.model.entity.UserEntity;
import com.example.plants.model.service.OrderServiceModel;
import com.example.plants.model.view.OrderViewModel;
import com.example.plants.repository.OrderRepository;
import com.example.plants.service.OrderService;
import com.example.plants.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOrder(Authentication auth, OrderServiceModel orderServiceModel) {

        UserEntity username = userService.findByUsername(auth.getName());
        OrderEntity byClientId = orderRepository.findByClientId(username.getId());
        OrderEntity orderEntity = modelMapper.map(orderServiceModel, OrderEntity.class);

        if (byClientId == null) {
            orderEntity.
                    setClient(username).
                    setCountOfOrder(1);
            orderRepository.save(orderEntity);
        } else {

            byClientId
                    .setAddress(orderServiceModel.getAddress())
                    .setCountOfOrder(byClientId.getCountOfOrder() + 1)
                    .setCity(orderServiceModel.getCity())
                    .setEmail(orderServiceModel.getEmail())
                    .setFullName(orderServiceModel.getFullName())
                    .setPhoneNumber(orderServiceModel.getPhoneNumber())
                    .setZip(orderServiceModel.getZip());

            orderRepository.save(byClientId);
        }


    }

    @Override
    public List<OrderViewModel> getAllOrders() {

        return orderRepository
                .findAll()
                .stream()
                .map(orders -> {
                    OrderViewModel orderViewModel = new OrderViewModel();
                    orderViewModel
                            .setFullName(orders.getFullName())
                            .setCountOfOrder(orders.getCountOfOrder())
                            .setEmail(orders.getEmail());
                    return orderViewModel;
                })
                .collect(Collectors.toList());
    }




}
