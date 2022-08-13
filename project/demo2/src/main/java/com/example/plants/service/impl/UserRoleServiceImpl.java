package com.example.plants.service.impl;

import com.example.plants.model.entity.UserRoleEntity;
import com.example.plants.model.entity.enums.UserRoleEnum;
import com.example.plants.repository.UserRoleRepository;
import com.example.plants.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoleEntity admin = new UserRoleEntity();
            admin.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity user = new UserRoleEntity();
            user.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(admin, user));
        }


    }
}
