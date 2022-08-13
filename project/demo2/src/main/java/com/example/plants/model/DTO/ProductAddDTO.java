package com.example.plants.model.DTO;

import com.example.plants.model.entity.enums.CategoryEnum;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductAddDTO {

    @NotBlank
    @Size(min = 5, max = 60)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String imageUrl;

    @NotNull
    private CategoryEnum category;

    @NotBlank
    private String light;

    @NotBlank
    private String water;

    @NotBlank
    private String soil;

    @NotBlank
    private String petSafety;


    public ProductAddDTO() {
    }



    public String getName() {
        return name;
    }

    public ProductAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ProductAddDTO setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductAddDTO setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductAddDTO setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductAddDTO setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductAddDTO setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }
}
