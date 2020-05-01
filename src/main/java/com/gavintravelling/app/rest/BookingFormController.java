package com.gavintravelling.app.rest;

import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.modelDto.BookingForm;
import com.gavintravelling.app.modelDto.HotelForm;
import com.gavintravelling.app.repository.BookedRoomRepository;
import com.gavintravelling.app.repository.BookingRepository;
import com.gavintravelling.app.repository.CustomerRepository;
import com.gavintravelling.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rest/")
public class BookingFormController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @PostMapping(value = "createBooking")
    public ResponseEntity<BookingForm> createBooking(@Valid @RequestBody BookingForm bookingForm,
                                                 BindingResult result){

        if(result.hasErrors()){
            return ResponseEntity.unprocessableEntity().body(bookingForm);
        }
        var customer = customerRepository.findByTokenId(bookingForm.getTokenId());
        Booking b = new Booking();
        b.setPersonCount(bookingForm.getPersonCount());
        b.setChildrenCount(bookingForm.getChildrenCount());
        b.setSmallChildrenCount(bookingForm.getSmallChildrenCount());
        b.setActiveBooking(true);
        b.setHalfPension(bookingForm.getHalfPension());
        b.setFullPension(bookingForm.getFullPension());
        b.setAllInclusive(bookingForm.getAllInclusive());
        b.setCustomer(customer);
        b.setTotalPrice(bookingForm.getTotalPrice());
        Booking booking = bookingRepository.save(b);

        bookingForm.getRoomsToBook().forEach(room -> {
            BookedRoom br = new BookedRoom();
            br.setId(new BookedRoomsId(booking.getId(), room.getRoomId()));
            br.setBooking(booking);
            br.setStartDate(bookingForm.getStartDate());
            br.setEndDate(bookingForm.getEndDate());
            br.setExtraBed(room.getExtraBed());
            Optional<Room> tempRoom = roomRepository.findById(room.getRoomId());
            tempRoom.ifPresent(br::setRoom);
            bookedRoomRepository.save(br);
        });
        return ResponseEntity.ok().body(bookingForm);
    }

}
