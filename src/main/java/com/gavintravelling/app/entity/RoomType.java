package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room_types")
public class RoomType {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    @Column
   private String roomType;
   private double price;

   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnore
   @JoinColumn(name = "hotel_id", referencedColumnName = "id")
   private Hotel hotel;

    public RoomType(){

     }


}
