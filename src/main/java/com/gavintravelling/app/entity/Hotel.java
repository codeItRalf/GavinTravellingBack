package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hotels")
public class Hotel {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    private String name;
    private int stars;
    private String picture;
    private String phone;
    private String eMail;
    private String address;
    private String postalCode;
    private boolean pool;
    private boolean nightEntertainment;
    private boolean restaurant;
    private boolean childrenClub;
    private double distanceToBeach;
    private double distanceToCenter;
    private double pensionHalfPrice;
    private double pensionFullPrice;
    private double allInclusive;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isNightEntertainment() {
        return nightEntertainment;
    }

    public void setNightEntertainment(boolean nightEntertainment) {
        this.nightEntertainment = nightEntertainment;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isChildrenClub() {
        return childrenClub;
    }

    public void setChildrenClub(boolean childrenClub) {
        this.childrenClub = childrenClub;
    }

    public double getDistanceToBeach() {
        return distanceToBeach;
    }

    public void setDistanceToBeach(double distanceToBeach) {
        this.distanceToBeach = distanceToBeach;
    }

    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    public void setDistanceToCenter(double distanceToCenter) {
        this.distanceToCenter = distanceToCenter;
    }

    public double getPensionHalfPrice() {
        return pensionHalfPrice;
    }

    public void setPensionHalfPrice(double pensionHalfPrice) {
        this.pensionHalfPrice = pensionHalfPrice;
    }

    public double getPensionFullPrice() {
        return pensionFullPrice;
    }

    public void setPensionFullPrice(double pensionFullPrice) {
        this.pensionFullPrice = pensionFullPrice;
    }

    public double getAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(double allInclusive) {
        this.allInclusive = allInclusive;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;


}
