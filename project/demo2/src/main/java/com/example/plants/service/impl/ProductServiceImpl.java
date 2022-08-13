package com.example.plants.service.impl;

import com.example.plants.model.DTO.ProductAddDTO;
import com.example.plants.model.entity.CategoryEntity;
import com.example.plants.model.entity.ProductEntity;
import com.example.plants.model.entity.enums.CategoryEnum;
import com.example.plants.model.service.ProductAddServiceModel;
import com.example.plants.model.service.ProductEditServiceModel;
import com.example.plants.model.view.ProductViewModel;
import com.example.plants.repository.ProductRepository;
import com.example.plants.service.CategoryService;
import com.example.plants.service.ProductService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);

    }

    @Override
    public void addOrder(ProductAddServiceModel productAddServiceModel) {
        ProductEntity productEntity = modelMapper.map(productAddServiceModel, ProductEntity.class);
        productEntity.setCategory(categoryService.findByCategoryNameEnum(productAddServiceModel.getCategory().getCategory()));
        productRepository.save(productEntity);
    }


    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductViewModel> getMostExpensiveProduct() {

        return productRepository.findTop3ByOrderByPriceDesc()
                .stream()
                .limit(3)
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllProductByCategoryEnum(CategoryEnum categoryEnum) {
        return productRepository.findByCategory_Category(categoryEnum)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }




    @Override
    public void edit(ProductEditServiceModel productEditServiceModel) {

        ProductEntity productEntity = productRepository.findById(productEditServiceModel.getId()).orElseThrow();


        productEntity.
                setName(productEditServiceModel.getName()).
                setPrice(productEditServiceModel.getPrice()).
                setLight(productEditServiceModel.getLight()).
                setSoil(productEditServiceModel.getSoil()).
                setPetSafety(productEditServiceModel.getPetSafety()).
                setWater(productEditServiceModel.getWater());

        productRepository.save(productEntity);
    }

    @Override
    public List<ProductViewModel> findAllPlants() {

        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }


}
