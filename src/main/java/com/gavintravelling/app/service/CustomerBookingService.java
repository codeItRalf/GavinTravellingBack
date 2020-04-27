package com.gavintravelling.app.service;

import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.modelDto.BookingDto;
import com.gavintravelling.app.modelDto.TokenId;
import com.gavintravelling.app.repository.BookedRoomRepository;
import com.gavintravelling.app.repository.BookingRepository;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerBookingService {

    private BookingRepository bookingRepository;
    private BookedRoomRepository bookedRoomRepository;

    public CustomerBookingService(BookingRepository bookingRepository, BookedRoomRepository bookedRoomRepository) {
        this.bookingRepository = bookingRepository;
        this.bookedRoomRepository = bookedRoomRepository;
    }


    public List<BookingDto> getCustomerBookings(TokenId tokenId){

        var bookings = bookingRepository.findByCustomer_TokenId(tokenId.getToken());
       return  bookings.stream().map(booking -> {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setPersonCount(booking.getPersonCount());
            bookingDto.setChildrenCount(booking.getChildrenCount());
            bookingDto.setSmallChildrenCount(booking.getSmallChildrenCount());
            bookingDto.setActiveBooking(booking.isActiveBooking());
            bookingDto.setAllInclusive(booking.getAllInclusive());
            bookingDto.setFullPension(booking.getFullPension());
            bookingDto.setHalfPension(booking.getHalfPension());
            bookingDto.setBookedRooms(bookedRoomRepository.findAllByBookingId(booking.getId()));
            return bookingDto;
        }).collect(Collectors.toList());
    }

}
