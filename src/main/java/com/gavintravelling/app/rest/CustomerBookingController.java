package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.BookingDto;
import com.gavintravelling.app.modelDto.TokenId;
import com.gavintravelling.app.repository.BookingRepository;
import com.gavintravelling.app.repository.CustomerRepository;
import com.gavintravelling.app.service.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/rest/user")
public class CustomerBookingController {


    private CustomerBookingService customerBookingService;

    public CustomerBookingController(CustomerBookingService customerBookingService) {
        this.customerBookingService = customerBookingService;
    }



    @PostMapping("bookings")
    public List<BookingDto> getAllBookingsByToken(@Valid @RequestBody TokenId tokenId){
        return customerBookingService.getCustomerBookings(tokenId);
    }

}
