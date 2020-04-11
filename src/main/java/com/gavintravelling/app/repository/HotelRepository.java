package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}