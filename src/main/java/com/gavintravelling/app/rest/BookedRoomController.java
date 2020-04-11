package com.gavintravelling.app.rest;

import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.repository.BookedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/bookedRoom")
public class BookedRoomController {

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    public BookedRoomController() {
    }

    @GetMapping
    public Iterable<BookedRoom> getAllCustomers(){
            return bookedRoomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookedRoom> getCustomerById(@PathVariable BookedRoomsId id){
    return bookedRoomRepository.findById(id);
    }

    @PostMapping
    public BookedRoom createCustomer(@RequestBody BookedRoom bookedRoom){
     return bookedRoomRepository.save(bookedRoom);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(){
      bookedRoomRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable BookedRoomsId id){
      bookedRoomRepository.deleteById(id);
    }

}
