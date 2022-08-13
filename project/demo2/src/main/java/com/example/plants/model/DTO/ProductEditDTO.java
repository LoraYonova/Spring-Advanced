package com.example.plants.model.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductEditDTO {

    private Long Id;

    @Size(min = 5, max = 60)
    private String name;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String light;

    @NotBlank
    private String water;

    @NotBlank
    private String soil;

    private String petSafety;

    public ProductEditDTO() {
    }

    public Long getId() {
        return Id;
    }

    public ProductEditDTO setId(Long id) {
        Id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEditDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEditDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductEditDTO setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductEditDTO setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductEditDTO setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductEditDTO setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }
}
