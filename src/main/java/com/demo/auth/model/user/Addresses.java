package com.demo.auth.model.user;

import com.demo.auth.model.BaseModel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "Addresses")
@Table(name = "addresses")
public class Addresses extends BaseModel {

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User addressOwner;

    @Column(name = "address_line_1",nullable = false)
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String country;

    public Addresses() {
    }

    public Addresses(String addressLine1,
                     String addressLine2, String city, String state,
                     String zipCode, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public User getAddressOwner() {
        return addressOwner;
    }

    public void setAddressOwner(User addressOwner) {
        this.addressOwner = addressOwner;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}