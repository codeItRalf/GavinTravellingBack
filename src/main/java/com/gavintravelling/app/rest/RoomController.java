package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;




    @GetMapping
    public Iterable<Room> getAllCustomers(){
            return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getCustomerById(@PathVariable long id){
    return roomRepository.findById(id);
    }

    @PostMapping
    public Room createCustomer(@RequestBody Room room){
     return roomRepository.save(room);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      roomRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      roomRepository.deleteById(id);
    }


}
