package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomer_TokenId(String customer_tokenId);
}