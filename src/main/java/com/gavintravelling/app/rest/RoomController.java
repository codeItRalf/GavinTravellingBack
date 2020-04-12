package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Review;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/rest/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;




    @GetMapping
    public Iterable<Room> getAllRooms(){
            return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable long id) throws ResourceNotFoundException {
        Room room = getEntity(id);
        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public Room createRoom(@Valid @RequestBody Room room){
     return roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id,
                                               @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        Room room = getEntity(id);

        room.setRoomNumber(roomDetails.getRoomNumber());
        room.setRoomType(roomDetails.getRoomType());


        final Room updatedRoom = roomRepository.save(room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/all")
    public void deleteAllRooms(@PathVariable long id){
      roomRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoomById(@PathVariable long id) throws ResourceNotFoundException {
        Room room = getEntity(id);

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Room getEntity(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));
    }
}
