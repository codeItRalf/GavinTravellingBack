package com.gavintravelling.app.rest;


import com.gavintravelling.app.entity.RoomType;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/rest/room-types")
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping("/by-hotel/{hotelId}")
    public Iterable<RoomType> getRoomTypesByHotel(@PathVariable long hotelId){
        return roomTypeRepository.getRoomTypesByHotelId(hotelId);
    }

    @GetMapping("/by-hotel/types/{hotelId}")
    public Iterable<RoomType> countRoomTypesByHotelId(@PathVariable long hotelId){
        return roomTypeRepository.countRoomTypesByHotelId(hotelId);
    }

    @GetMapping
    public Iterable<RoomType> getAllRoomTypes(){
            return roomTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable long id) throws ResourceNotFoundException {
        RoomType roomType = getEntity(id);
        return ResponseEntity.ok().body(roomType);
    }

    @PostMapping
    public RoomType createRoomType(@RequestBody RoomType roomType){
     return roomTypeRepository.save(roomType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable Long id,
                                           @Valid @RequestBody RoomType roomTypeDetails) throws ResourceNotFoundException {
        RoomType roomType = getEntity(id);

        roomType.setRoomType(roomTypeDetails.getRoomType());
        roomType.setPrice(roomTypeDetails.getPrice());
        final RoomType updatedRoomType = roomTypeRepository.save(roomType);
        return ResponseEntity.ok(updatedRoomType);
    }

    @DeleteMapping("/all")
    public void deleteAllRoomTypes(@PathVariable long id){
      roomTypeRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoomTypeById(@PathVariable long id) throws ResourceNotFoundException {
        RoomType roomType = getEntity(id);

        roomTypeRepository.delete(roomType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private RoomType getEntity(Long id) throws ResourceNotFoundException {
        return roomTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room type not found for this id :: " + id));
    }

}
