package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "rooms")
public class Room {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    @Column(name = "rooms_number")
    private int roomNumber;
//
//    @ManyToMany(mappedBy = "bookedRooms")
//    private Set<Booking> bookings;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<BookedRoom> rooms;



    public Room(){

     }




}
