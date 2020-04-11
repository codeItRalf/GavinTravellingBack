package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;




    @GetMapping
    public Iterable<Hotel> getAllCustomers(){
            return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getCustomerById(@PathVariable long id){
    return hotelRepository.findById(id);
    }

    @PostMapping
    public Hotel createCustomer(@RequestBody Hotel hotel){
     return hotelRepository.save(hotel);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      hotelRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      hotelRepository.deleteById(id);
    }

}
