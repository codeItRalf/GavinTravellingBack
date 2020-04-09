package com.gavintravelling.app.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "customers")
public class Customer {


 public Customer(){

  };

    @Id
    private long id;

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String eMail;
  private String personNumber;
  private String password;

}
