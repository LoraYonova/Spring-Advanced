package com.example.plants.service;

import com.example.plants.model.DTO.ProductAddDTO;
import com.example.plants.model.entity.ProductEntity;
import com.example.plants.model.entity.enums.CategoryEnum;
import com.example.plants.model.service.ProductAddServiceModel;
import com.example.plants.model.service.ProductEditServiceModel;
import com.example.plants.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {

    ProductEntity findById(Long id);

    void addOrder(ProductAddServiceModel productAddServiceModel);

    void delete(Long id);

    List<ProductViewModel> getMostExpensiveProduct();

    List<ProductViewModel> findAllProductByCategoryEnum(CategoryEnum categoryEnum);


    void edit(ProductEditServiceModel productEditServiceModel);

    List<ProductViewModel> findAllPlants();
}
