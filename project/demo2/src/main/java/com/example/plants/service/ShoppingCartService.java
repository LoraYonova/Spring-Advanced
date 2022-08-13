package com.example.plants.service;

import com.example.plants.model.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {
    Map<ProductEntity, Integer> productsInCart();

    BigDecimal totalSum();

    void addProduct(ProductEntity productEntity);

    void removeProduct(ProductEntity productEntity);

    void clearProducts();
}
