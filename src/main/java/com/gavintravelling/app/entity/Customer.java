package com.gavintravelling.app.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String eMail;
    private String personNumber;
    private String password;

    public Customer(){

     }

     Customer(String firstName, String lastName, String phoneNumber, String eMail, String personNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.personNumber = personNumber;
        this.password = password;
    }


}
