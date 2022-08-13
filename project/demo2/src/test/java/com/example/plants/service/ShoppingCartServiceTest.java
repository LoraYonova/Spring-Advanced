package com.example.plants.service;

import com.example.plants.creator.ProductCreator;
import com.example.plants.model.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class ShoppingCartServiceTest {

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    public void checkIfShoppingCartServiceIsNotNull() {
        initMocks(this);

        assertThat(shoppingCartService).isNotNull();
    }

    @Test
    public void addProductToCartTests(){
        Map<ProductEntity, Integer> cart = new LinkedHashMap<>();
        ProductEntity product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
    }

    @Test
    public void addTwoTheSameProductsToCartTests(){
        Map<ProductEntity, Integer> cart = new LinkedHashMap<>();
        ProductEntity product = ProductCreator.createTestProduct();
        ProductEntity product2 = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        product.setName("Not Bad Trainers");
        product2.setName("Nice Shoes");

        cart.put(product, 1);
        cart.put(product2, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
        assertThat(shoppingCartService.productsInCart()).containsKey(product2);
    }

    @Test
    public void removeProductFromCartTests(){
        Map<ProductEntity, Integer> cart = new LinkedHashMap<>();
        ProductEntity product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);
        assertThat(shoppingCartService.productsInCart()).containsKey(product);

        cart.remove(product);
        assertThat(shoppingCartService.productsInCart()).doesNotContainKey(product);
    }
}
