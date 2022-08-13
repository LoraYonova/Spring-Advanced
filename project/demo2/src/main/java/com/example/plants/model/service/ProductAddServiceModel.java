package com.example.plants.model.service;

import com.example.plants.model.entity.CategoryEntity;
import com.example.plants.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;


public class ProductAddServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private CategoryEntity category;
    private String light;
    private String water;
    private String soil;
    private String petSafety;

    public ProductAddServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public ProductAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ProductAddServiceModel setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductAddServiceModel setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductAddServiceModel setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductAddServiceModel setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductAddServiceModel setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }
}
