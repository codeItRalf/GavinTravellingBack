package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.RoomType;
import com.gavintravelling.app.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;




    @GetMapping
    public Iterable<RoomType> getAllCustomers(){
            return roomTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RoomType> getCustomerById(@PathVariable long id){
    return roomTypeRepository.findById(id);
    }

    @PostMapping
    public RoomType createCustomer(@RequestBody RoomType roomType){
     return roomTypeRepository.save(roomType);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      roomTypeRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      roomTypeRepository.deleteById(id);
    }

}
