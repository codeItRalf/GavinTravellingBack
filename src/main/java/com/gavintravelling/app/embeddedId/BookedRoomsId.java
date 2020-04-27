package com.gavintravelling.app.embeddedId;


import javax.persistence.*;
import java.io.Serializable;



@Embeddable
public class BookedRoomsId implements Serializable {

    @Column(name = "booking_id")
    private   Long bookingId;


     @Column(name = "room_id")
     private   Long roomId;

    public BookedRoomsId() {
    }

    public BookedRoomsId(Long bookingId, Long roomsId) {
        this.bookingId = bookingId;
        this.roomId = roomsId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookedRoomsId that = (BookedRoomsId) o;

        if (!getBookingId().equals(that.getBookingId())) return false;
        return getRoomId().equals(that.getRoomId());
    }

    @Override
    public int hashCode() {
        int result = getBookingId().hashCode();
        result = 31 * result + getRoomId().hashCode();
        return result;
    }
}
