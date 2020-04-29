package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.entity.RoomType;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.BookingDto;
import com.gavintravelling.app.modelDto.TokenId;
import com.gavintravelling.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @PostMapping(value = "user")
    public List<BookingDto> getBookingByTokenId(@Valid @RequestBody TokenId tokenId){
        return bookingRepository.getBookingByTokenId(tokenId.getTokenId())
                .stream()
                .map(booking -> {
                    BookingDto bookingDto = new BookingDto();
                    List<BookedRoom> arr = Arrays.stream(booking.getRooms().toArray()).map(s -> {
                        return ((BookedRoom) s);
                    }).collect(Collectors.toList());
                    Hotel hotel = arr.get(0).getRoom().getRoomType().getHotel();
                    bookingDto.setCityName(hotel.getCity().getName());
                    bookingDto.setHotelId(hotel.getId());
                    bookingDto.setHotelName(hotel.getName());
                    bookingDto.setActive(booking.isActiveBooking());
                    bookingDto.setBookedRoomList(booking.getRooms());
                    return bookingDto;
                }).collect(Collectors.toList());
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
        booking.setActiveBooking(bookingDetails.isActiveBooking());
        booking.setHalfPension(bookingDetails.getHalfPension());
        booking.setFullPension(bookingDetails.getFullPension());
        booking.setAllInclusive(bookingDetails.getAllInclusive());
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
