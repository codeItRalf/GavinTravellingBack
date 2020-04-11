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

    public Hotel(){

     }

   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnore
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;


}
