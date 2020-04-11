package com.gavintravelling.app.entity;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "booked_rooms")
public class BookedRoom implements Serializable {


    @EmbeddedId
    private BookedRoomsId id;

    private int extraBed;
    private Date startDate;
    private Date endDate;

    public BookedRoom() {
    }


}
