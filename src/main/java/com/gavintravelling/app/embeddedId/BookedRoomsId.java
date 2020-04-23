package com.gavintravelling.app.embeddedId;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
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
}
