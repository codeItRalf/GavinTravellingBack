package com.gavintravelling.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "cities")
public class City {

    private  @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "city",
            cascade = CascadeType.ALL)
    private Set<Hotel> hotels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
