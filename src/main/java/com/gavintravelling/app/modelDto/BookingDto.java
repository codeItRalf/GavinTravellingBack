package com.gavintravelling.app.modelDto;

import com.gavintravelling.app.entity.BookedRoom;

import java.util.List;
import java.util.Set;

public class BookingDto {
    private Long hotelId;
    private String hotelName;
    private String cityName;
    private boolean active;
    private Set<BookedRoom> bookedRoomList;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<BookedRoom> getBookedRoomList() {
        return bookedRoomList;
    }

    public void setBookedRoomList(Set<BookedRoom> bookedRoomList) {
        this.bookedRoomList = bookedRoomList;
    }
}
