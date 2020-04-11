package com.gavintravelling.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;
    private int personCount;
    private int childrenCount;
    private int smallChildrenCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Booking(){

     }



}
