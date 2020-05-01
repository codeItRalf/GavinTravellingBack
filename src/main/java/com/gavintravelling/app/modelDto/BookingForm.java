package com.gavintravelling.app.modelDto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class BookingForm {
    private int personCount;
    private int childrenCount;
    private int smallChildrenCount;
    private int halfPension;
    private int fullPension;
    private int allInclusive;
    private String tokenId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private List<RoomDto> roomsToBook;
    private Double totalPrice;


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<RoomDto> getRoomsToBook() {
        return roomsToBook;
    }

    public void setRoomsToBook(List<RoomDto> roomsToBook) {
        this.roomsToBook = roomsToBook;
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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
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
}
