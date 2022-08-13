package com.example.plants.init;

import com.example.plants.service.CategoryService;
import com.example.plants.service.UserRoleService;
import com.example.plants.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserRoleService userRoleService;
    private final UserService userService;


    public DBInit(CategoryService categoryService, UserRoleService userRoleService, UserService userService) {
        this.categoryService = categoryService;
        this.userRoleService = userRoleService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.initializeCategory();
        userRoleService.initializeRoles();
        userService.initializeAdmin();
    }


}
