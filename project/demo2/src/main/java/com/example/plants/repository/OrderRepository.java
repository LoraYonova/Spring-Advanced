package com.example.plants.repository;

import com.example.plants.model.entity.OrderEntity;
import com.example.plants.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByClientId(Long client_id);


}
