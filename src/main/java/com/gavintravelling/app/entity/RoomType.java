package com.gavintravelling.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room_types")
public class RoomType {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

   private String roomType;
   private double price;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "hotel_id", referencedColumnName = "id")
   private Hotel hotel;

    public RoomType(){

     }


}
