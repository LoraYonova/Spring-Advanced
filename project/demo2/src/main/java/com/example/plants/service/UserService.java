package com.example.plants.service;

import com.example.plants.model.DTO.UserRegisterDTO;
import com.example.plants.model.entity.UserEntity;

public interface UserService {
    void initializeAdmin();

    void registerAndLogin(UserRegisterDTO userRegisterDTO);

    UserEntity findById(Long id);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
