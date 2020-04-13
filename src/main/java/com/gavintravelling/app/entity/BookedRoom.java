package com.gavintravelling.app.entity;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "booked_rooms")
public class BookedRoom {


    @EmbeddedId
    private BookedRoomsId id;

    @ManyToOne
    @MapsId("booking_id")
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @MapsId("room_id")
    @JoinColumn(name = "room_id")
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

}
