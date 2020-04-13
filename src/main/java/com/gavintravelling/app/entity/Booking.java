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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


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
}
