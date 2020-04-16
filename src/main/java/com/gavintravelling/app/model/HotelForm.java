package com.gavintravelling.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HotelForm {
    private String cityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int roomCount;
    private double distCenter;
    private double distBeach;
    private boolean havePool;
    private boolean haveNightEntertain;
    private boolean haveChildrenClub;
    private boolean haveRestaurant;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public double getDistCenter() {
        return distCenter;
    }

    public void setDistCenter(double distCenter) {
        this.distCenter = distCenter;
    }

    public double getDistBeach() {
        return distBeach;
    }

    public void setDistBeach(double distBeach) {
        this.distBeach = distBeach;
    }

    public boolean isHavePool() {
        return havePool;
    }

    public void setHavePool(boolean havePool) {
        this.havePool = havePool;
    }

    public boolean isHaveNightEntertain() {
        return haveNightEntertain;
    }

    public void setHaveNightEntertain(boolean haveNightEntertain) {
        this.haveNightEntertain = haveNightEntertain;
    }

    public boolean isHaveChildrenClub() {
        return haveChildrenClub;
    }

    public void setHaveChildrenClub(boolean haveChildrenClub) {
        this.haveChildrenClub = haveChildrenClub;
    }

    public boolean isHaveRestaurant() {
        return haveRestaurant;
    }

    public void setHaveRestaurant(boolean haveRestaurant) {
        this.haveRestaurant = haveRestaurant;
    }
}
