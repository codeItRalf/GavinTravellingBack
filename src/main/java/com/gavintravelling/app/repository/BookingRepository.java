package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.modelDto.TokenId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomer_TokenId(String customer_tokenId);

    @Query("SELECT DISTINCT b FROM Booking b INNER JOIN BookedRoom br ON b.id = br.booking.id WHERE (b.customer.tokenId = :tokenId) GROUP BY b.id")
    List<Booking> getBookingByTokenId(String tokenId);
}