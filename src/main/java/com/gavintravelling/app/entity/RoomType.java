package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room_types")
public class RoomType {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    @Column
    private String roomType;
    private double price;

    @ManyToOne(optional = false,
            cascade = CascadeType.REMOVE)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @JsonIgnore
    @OneToMany( mappedBy = "roomType",
            cascade = CascadeType.REMOVE)
    private Set<Room> rooms;

    public RoomType(){}
    public RoomType(String roomtype, Double pris){
        this.roomType = roomtype;
        this.price = pris;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
