package com.example.plants.model.entity;

import com.example.plants.model.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;



    public CategoryEntity() {
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public CategoryEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }


}
