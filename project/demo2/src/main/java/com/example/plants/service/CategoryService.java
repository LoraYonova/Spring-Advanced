package com.example.plants.service;

import com.example.plants.model.entity.CategoryEntity;
import com.example.plants.model.entity.enums.CategoryEnum;

public interface CategoryService {
    void initializeCategory();

    CategoryEntity findByCategoryNameEnum(CategoryEnum category);
}
