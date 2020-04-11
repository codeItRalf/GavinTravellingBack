package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}