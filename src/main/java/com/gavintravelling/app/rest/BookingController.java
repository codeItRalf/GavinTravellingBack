package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;




    @GetMapping
    public Iterable<Booking> getAllBookings(){
            return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingsById(@PathVariable long id){
    return bookingRepository.findById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
     return bookingRepository.save(booking);
    }


    @DeleteMapping("/all")
    public void deleteAllBookings(@PathVariable long id){
      bookingRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable long id){
      bookingRepository.deleteById(id);
    }

}
