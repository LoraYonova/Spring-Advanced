package com.example.plants.creator;

import com.example.plants.model.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductCreator {

    public static final String NAME = "Test";
    public static final String DESCRIPTION = "testDescription";
    public static final BigDecimal PRICE = BigDecimal.valueOf(20);
    public static final String IMAGE_URL = "https://res.cloudinary.com/lorayonova/image/upload/v1659640573/plants/GettyImages-760284635-f382b52c660e4771a875aad5312c0a48_lcku4g.webp";
    public static final String LIGHT = "Full sun";
    public static final String PET_SAFETY = " Nontoxic to dogs and cats.";
    public static final String SOIL = "Light, well-draining.";
    public static final String WATER = "Every one to two weeks.";


    public static ProductEntity createTestProduct(){
        ProductEntity testProduct = new ProductEntity();

        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);
        testProduct.setImageUrl(IMAGE_URL);
        testProduct.setLight(LIGHT);
        testProduct.setPetSafety(PET_SAFETY);
        testProduct.setSoil(SOIL);
        testProduct.setWater(WATER);

        return testProduct;
    }

    public static Set<ProductEntity> createTestProducts(){
        Set<ProductEntity> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }

}

