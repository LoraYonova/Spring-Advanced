package com.example.plants.model.view;


import java.math.BigDecimal;

public class ShoppingCartViewModel {

    private String name;
    private BigDecimal price;
    private String imageUrl;

    public ShoppingCartViewModel() {
    }

    public String getName() {
        return name;
    }

    public ShoppingCartViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShoppingCartViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ShoppingCartViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
