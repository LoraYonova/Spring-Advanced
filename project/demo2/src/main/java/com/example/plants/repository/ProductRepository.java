package com.example.plants.repository;

import com.example.plants.model.entity.ProductEntity;
import com.example.plants.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategory_Category(CategoryEnum category_category);

    List<ProductEntity> findTop3ByOrderByPriceDesc();

}