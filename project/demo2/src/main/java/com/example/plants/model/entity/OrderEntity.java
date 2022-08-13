package com.example.plants.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private int zip;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    private UserEntity client;

    @Column(name = "count_of_order")
    private Integer countOfOrder;


    public OrderEntity() {
    }


    public String getFullName() {
        return fullName;
    }

    public OrderEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public int getZip() {
        return zip;
    }

    public OrderEntity setZip(int zip) {
        this.zip = zip;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity getClient() {
        return client;
    }

    public OrderEntity setClient(UserEntity client) {
        this.client = client;
        return this;
    }

    public Integer getCountOfOrder() {
        return countOfOrder;
    }

    public OrderEntity setCountOfOrder(Integer countOfOrder) {
        this.countOfOrder = countOfOrder;
        return this;
    }
}
