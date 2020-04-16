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
    private boolean activeBooking;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

   @OneToOne(mappedBy = "booking")
   @JsonIgnore
   private Review review;

    @OneToMany(mappedBy = "booking")
    @JsonIgnore
    private Set<BookedRoom> rooms;


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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
