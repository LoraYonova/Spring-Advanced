package com.example.plants.model.service;


import java.math.BigDecimal;

public class ProductEditServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private String light;
    private String water;
    private String soil;
    private String petSafety;

    public ProductEditServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductEditServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEditServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEditServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductEditServiceModel setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductEditServiceModel setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductEditServiceModel setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductEditServiceModel setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }
}
