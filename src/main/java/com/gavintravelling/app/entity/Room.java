package com.gavintravelling.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rooms")
public class Room {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    @Column(name = "rooms_number")
    private int roomNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType roomType;

    public Room(){

     }




}
