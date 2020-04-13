package com.gavintravelling.app.rest;

import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/rest/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;




    @GetMapping
    public Iterable<Booking> getAllBookings(){
            return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingsById(@PathVariable long id)
       throws ResourceNotFoundException {
            Booking booking = getEntity(id);
            return ResponseEntity.ok().body(booking);
    }

    @PostMapping
    public Booking createBooking(@Valid @RequestBody Booking booking){
     return bookingRepository.save(booking);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,
                                                       @Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
        Booking booking = getEntity(id);

        booking.setPersonCount(bookingDetails.getPersonCount());
        booking.setChildrenCount(bookingDetails.getChildrenCount());
        booking.setSmallChildrenCount(bookingDetails.getSmallChildrenCount());
        final Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/all")
    public void deleteAllBookings(@PathVariable long id){
      bookingRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBookingById(@PathVariable long id) throws ResourceNotFoundException {
        Booking booking = getEntity(id);

        bookingRepository.delete(booking);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Booking getEntity(Long id) throws ResourceNotFoundException {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + id));
    }

}
