package com.gavintravelling.app.rest;

import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.TokenId;
import com.gavintravelling.app.repository.BookedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/rest/booked-rooms")
public class BookedRoomController {

    @Autowired
    private BookedRoomRepository bookedRoomRepository;


    @GetMapping
    public Iterable<BookedRoom> getAllBookedRooms(){
            return bookedRoomRepository.findAll();
    }

    @GetMapping("/{bookingId}/{roomId}")
    public ResponseEntity<BookedRoom> getBookedRoomById(@PathVariable Long bookingId, @PathVariable Long roomId)
         throws ResourceNotFoundException {
        BookedRoom bookedRoom = getEntity(bookingId, roomId);
            return ResponseEntity.ok().body(bookedRoom);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<List<BookedRoom>> getBookedRoomByBookingId(@PathVariable Long bookingId)
            throws ResourceNotFoundException {
        var bookedRooms = bookedRoomRepository.findAllByBookingId(bookingId);
        return ResponseEntity.ok().body(bookedRooms);
    }


    @PostMapping
    public BookedRoom createBookedRoom(@Valid @RequestBody BookedRoom bookedRoom){
     return bookedRoomRepository.save(bookedRoom);
    }

    @PutMapping("/{bookingId}/{roomId}")
    public ResponseEntity<BookedRoom> updateBookedRoom(@PathVariable Long bookingId, @PathVariable Long roomId,
                                                   @Valid @RequestBody BookedRoom bookedRoomDetails) throws ResourceNotFoundException {
        BookedRoom bookedRoom = getEntity(bookingId, roomId);

        bookedRoom.setStartDate(bookedRoomDetails.getStartDate());
        bookedRoom.setEndDate(bookedRoomDetails.getEndDate());
        bookedRoom.setExtraBed(bookedRoomDetails.getExtraBed());
        final BookedRoom updatedBookedRoom = bookedRoomRepository.save(bookedRoom);
        return ResponseEntity.ok(updatedBookedRoom);
    }


    @DeleteMapping("/all")
    public void deleteAllBookedRooms(){
      bookedRoomRepository.deleteAll();
    }

    @DeleteMapping("/{bookingId}/{roomId}")
    public Map<String, Boolean> deleteBookedRoomById(@PathVariable Long bookingId, @PathVariable Long roomId)
          throws ResourceNotFoundException {
            BookedRoom bookedRoom =  getEntity(bookingId,roomId);

            bookedRoomRepository.delete(bookedRoom);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;

    }


    @PostMapping("user")
    public List<BookedRoom> getAllBookingsByToken(@Valid @RequestBody TokenId tokenId){
        return bookedRoomRepository.findAllByBookingCustomerTokenId(tokenId.getTokenId());
    }


    private BookedRoom getEntity(Long bookingId, Long roomId) throws ResourceNotFoundException {
              return bookedRoomRepository.findById(new BookedRoomsId(bookingId, roomId))
                    .orElseThrow(() -> new ResourceNotFoundException("Booked room not found for this id :: booking_id:" + bookingId + ", room_id: " + roomId));
        }
}
