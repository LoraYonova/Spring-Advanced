package com.example.plants.model.DTO;


import javax.validation.constraints.*;

public class OrderDTO {

    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;

    @NotBlank
    private String city;

    @Positive
    @NotNull
    private int zip;

    @NotBlank
    @Size(min = 5, max = 100)
    private String address;

    @NotNull
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    public OrderDTO() {
    }


    public String getFullName() {
        return fullName;
    }

    public OrderDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public int getZip() {
        return zip;
    }

    public OrderDTO setZip(int zip) {
        this.zip = zip;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
