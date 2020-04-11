package com.gavintravelling.app.embeddedId;

import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Room;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Embeddable()
public class BookedRoomsId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "room_id")
     private Room room;

    public BookedRoomsId() {
    }

    public BookedRoomsId(Booking bookingId, Room roomId ) {
        this.booking = bookingId;
        this.room = roomId;
    }
}
