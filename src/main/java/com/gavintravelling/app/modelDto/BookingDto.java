package com.gavintravelling.app.modelDto;

import com.gavintravelling.app.entity.BookedRoom;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class BookingDto {

    private Long id;
    private int personCount;
    private int childrenCount;
    private int smallChildrenCount;
    private boolean activeBooking;
    private int fullPension;
    private int halfPension;
    private int allInclusive;
    private List<BookedRoom> bookedRooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getSmallChildrenCount() {
        return smallChildrenCount;
    }

    public void setSmallChildrenCount(int smallChildrenCount) {
        this.smallChildrenCount = smallChildrenCount;
    }

    public boolean isActiveBooking() {
        return activeBooking;
    }

    public void setActiveBooking(boolean activeBooking) {
        this.activeBooking = activeBooking;
    }

    public int getFullPension() {
        return fullPension;
    }

    public void setFullPension(int fullPension) {
        this.fullPension = fullPension;
    }

    public int getHalfPension() {
        return halfPension;
    }

    public void setHalfPension(int halfPension) {
        this.halfPension = halfPension;
    }

    public int getAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(int allInclusive) {
        this.allInclusive = allInclusive;
    }

    public List<BookedRoom> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(List<BookedRoom> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }
}
