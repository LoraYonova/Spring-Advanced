package com.example.plants.service.impl;

import com.example.plants.model.entity.ProductEntity;
import com.example.plants.service.ShoppingCartService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<ProductEntity, Integer> shoppingCart = new LinkedHashMap<>();

    @Override
    public Map<ProductEntity, Integer> productsInCart() {
        return Collections.unmodifiableMap(shoppingCart);
    }

    @Override
    public BigDecimal totalSum() {
        return shoppingCart.entrySet()
                .stream()
                .map(p -> p.getKey().getPrice().multiply(BigDecimal.valueOf(p.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        if (shoppingCart.containsKey(productEntity)) {
            shoppingCart.replace(productEntity, shoppingCart.get(productEntity) + 1);
        } else {
            shoppingCart.put(productEntity, 1);
        }
    }

    @Override
    public void removeProduct(ProductEntity productEntity) {
        if (shoppingCart.containsKey(productEntity)) {
            if (shoppingCart.get(productEntity) == 1) {
                shoppingCart.remove(productEntity);
            } else if (shoppingCart.get(productEntity) > 1) {
                shoppingCart.replace(productEntity, shoppingCart.get(productEntity) - 1);
            }
        }
    }

    @Override
    public void clearProducts() {
        shoppingCart.clear();
    }
}