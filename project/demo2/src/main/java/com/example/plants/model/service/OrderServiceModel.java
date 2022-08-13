package com.example.plants.model.service;

import com.example.plants.model.entity.UserEntity;

public class OrderServiceModel {

    private String fullName;
    private String city;
    private int zip;
    private String address;
    private String phoneNumber;
    private String email;
    private UserEntity userId;
    private Integer countOfOrder;

    public OrderServiceModel() {
    }


    public String getFullName() {
        return fullName;
    }

    public OrderServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderServiceModel setCity(String city) {
        this.city = city;
        return this;
    }

    public int getZip() {
        return zip;
    }

    public OrderServiceModel setZip(int zip) {
        this.zip = zip;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public OrderServiceModel setUserId(UserEntity userId) {
        this.userId = userId;
        return this;
    }

    public Integer getCountOfOrder() {
        return countOfOrder;
    }

    public OrderServiceModel setCountOfOrder(Integer countOfOrder) {
        this.countOfOrder = countOfOrder;
        return this;
    }
}
