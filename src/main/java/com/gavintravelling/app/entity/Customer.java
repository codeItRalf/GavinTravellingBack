package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(name = "e_mail")
    private String EMail;
    private String personNumber;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber, String eMail, String personNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.EMail = eMail;
        this.personNumber = personNumber;
        this.password = password;
    }

    public Customer(String email, String password) {
        this.firstName = "test";
        this.lastName = "test";
        this.phoneNumber = "0739990855";
        this.EMail = email;
        this.personNumber = "9999999";
        this.password = password;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEMail() {
        return EMail;
    }

    public void seteEMail(String eMail) {
        this.EMail = eMail;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }


}
