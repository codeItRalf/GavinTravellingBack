package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;
    private int personCount;
    private int childrenCount;
    private int smallChildrenCount;

//    @ManyToMany(cascade = CascadeType.ALL)
//            @JoinTable(
//                    name = "booked_rooms",
//                    joinColumns = @JoinColumn(name = "booking_id"),
//                    inverseJoinColumns = @JoinColumn(name = "room_id")
//            )
//   private Set<Room> bookedRooms;

    @OneToMany(mappedBy = "booking")
    @JsonIgnore
    private Set<BookedRoom> rooms;



}
