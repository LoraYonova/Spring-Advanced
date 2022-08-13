package com.example.plants.model.view;

public class OrderViewModel {

    private String fullName;
    private Integer countOfOrder;
    private String email;


    public OrderViewModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public OrderViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getCountOfOrder() {
        return countOfOrder;
    }

    public OrderViewModel setCountOfOrder(Integer countOfOrder) {
        this.countOfOrder = countOfOrder;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderViewModel setEmail(String email) {
        this.email = email;
        return this;
    }
}

