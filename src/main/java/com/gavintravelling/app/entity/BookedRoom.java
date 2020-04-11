package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gavintravelling.app.embeddedId.BookedRoomsId;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "booked_rooms")
public class BookedRoom {


    @EmbeddedId
    private BookedRoomsId id;

    @ManyToOne
    @MapsId("booking_id")
    @JsonIgnore
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @MapsId("room_id")
    @JsonIgnore
    @JoinColumn(name = "room_id")
    private Room room;


    private int extraBed;
    private Date startDate;
    private Date endDate;


    public BookedRoom() {
    }

}
