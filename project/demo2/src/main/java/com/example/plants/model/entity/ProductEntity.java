package com.example.plants.model.entity;

import com.example.plants.model.DTO.ProductAddDTO;
import com.example.plants.model.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

    @Column(nullable = false)
    private String light;

    @Column(nullable = false)
    private String water;

    @Column(nullable = false)
    private String soil;

    @Column(nullable = false)
    private String petSafety;


    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ProductEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getLight() {
        return light;
    }

    public ProductEntity setLight(String light) {
        this.light = light;
        return this;
    }

    public String getWater() {
        return water;
    }

    public ProductEntity setWater(String water) {
        this.water = water;
        return this;
    }

    public String getSoil() {
        return soil;
    }

    public ProductEntity setSoil(String soil) {
        this.soil = soil;
        return this;
    }

    public String getPetSafety() {
        return petSafety;
    }

    public ProductEntity setPetSafety(String petSafety) {
        this.petSafety = petSafety;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity productEntity = (ProductEntity) o;

        return getId() == productEntity.getId();

    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }


}
