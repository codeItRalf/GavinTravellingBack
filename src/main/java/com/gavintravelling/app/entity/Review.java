package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    private String rating;
    private String comment;

    public Review(){

     }
     @OneToOne(cascade = CascadeType.ALL)
     @JsonIgnore
     @JoinColumn(name = "booking_id", referencedColumnName = "id")
     private Booking booking;

}
