package com.gavintravelling.app.modelDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gavintravelling.app.entity.City;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.entity.RoomType;

import javax.persistence.*;
import java.util.Set;

public class HotelDto extends Hotel {
     private double bestPrice;

    public HotelDto() {
    }

    public HotelDto(Hotel hotel, double bestPrice) {
        setName(hotel.getName());
        setStars(hotel.getStars());
        setPicture(hotel.getPicture());
        setPhone(hotel.getPhone());
        seteMail(hotel.geteMail());
        setAddress(hotel.getAddress());
        setPostalCode(hotel.getPostalCode());
        setPool(hotel.isPool());
        setNightEntertainment(hotel.isNightEntertainment());
        setRestaurant(hotel.isRestaurant());
        setChildrenClub(hotel.isChildrenClub());
        setDistanceToBeach(hotel.getDistanceToBeach());
        setDistanceToCenter(hotel.getDistanceToCenter());
        setPensionHalfPrice(hotel.getPensionHalfPrice());
        setPensionFullPrice(hotel.getPensionFullPrice());
        setAllInclusive(hotel.getAllInclusive());
        setExtraBed(hotel.getExtraBed());
        setRoomTypes(hotel.getRoomTypes());
        setCity(hotel.getCity());
        this.bestPrice = bestPrice;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(double bestPrice) {
        this.bestPrice = bestPrice;
    }


}
