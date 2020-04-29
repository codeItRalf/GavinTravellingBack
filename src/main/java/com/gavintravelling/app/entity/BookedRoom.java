package com.gavintravelling.app.entity;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "booked_rooms")
public class BookedRoom implements Serializable {


    @EmbeddedId
    private BookedRoomsId id;

    @ManyToOne
    @MapsId("bookingId")
    private Booking booking;

    @ManyToOne
    @MapsId("roomId")
    private Room room;


    private int extraBed;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    public int getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(int extraBed) {
        this.extraBed = extraBed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BookedRoom() {
    }

    public BookedRoomsId getId() {
        return id;
    }

    public void setId(BookedRoomsId id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
