package com.example.plants.service.impl;

import com.example.plants.model.entity.CategoryEntity;
import com.example.plants.model.entity.enums.CategoryEnum;
import com.example.plants.repository.CategoryRepository;
import com.example.plants.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategory() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        CategoryEntity category = new CategoryEntity();
                        category.setCategory(categoryEnum);
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryEnum category) {
        return categoryRepository.findByCategory(category).orElseThrow();

    }
}
