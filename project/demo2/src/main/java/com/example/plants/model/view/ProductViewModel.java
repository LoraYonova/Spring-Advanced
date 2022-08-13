package com.example.plants.model.view;

import java.math.BigDecimal;

public class ProductViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private String imageUrl;
    private String description;
    private String light;
    private String water;
    private String soil;
    private String petSafety;



    public ProductViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductViewModel setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductViewModel setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductViewModel setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductViewModel setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }
}
