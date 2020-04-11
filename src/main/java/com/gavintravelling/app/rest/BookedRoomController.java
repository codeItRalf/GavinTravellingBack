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


    @GetMapping
    public Iterable<BookedRoom> getAllBookedRooms(){
            return bookedRoomRepository.findAll();
    }

    @GetMapping("/{bookingId}/{roomId}")
    public Optional<BookedRoom> getBookedRoomById(@PathVariable Long bookingId, @PathVariable Long roomId){
    return bookedRoomRepository.findById(new BookedRoomsId(bookingId, roomId));
    }

    @PostMapping
    public BookedRoom createBookedRoom(@RequestBody BookedRoom bookedRoom){
     return bookedRoomRepository.save(bookedRoom);
    }


    @DeleteMapping("/all")
    public void deleteAllBookedRooms(){
      bookedRoomRepository.deleteAll();
    }

    @DeleteMapping("/{bookingId}/{roomId}")
    public void deleteBookedRoomById(@PathVariable Long bookingId, @PathVariable Long roomId){
      bookedRoomRepository.deleteById(new BookedRoomsId(bookingId, roomId));
    }

}
