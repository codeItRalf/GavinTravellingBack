package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;




    @GetMapping
    public Iterable<Hotel> getAllHotels(){
            return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable long id) throws ResourceNotFoundException {

        Hotel hotel = getEntity(id);
        return ResponseEntity.ok().body(hotel);
    }

    @PostMapping
    public Hotel createHotel(@Valid @RequestBody Hotel hotel){
     return hotelRepository.save(hotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id,
                                                   @Valid @RequestBody Hotel hotelDetails) throws ResourceNotFoundException {
        Hotel hotel = getEntity(id);

        hotel.setName(hotelDetails.getName());
        hotel.setStars(hotelDetails.getStars());
        hotel.setCity(hotelDetails.getCity());
        hotel.setPicture(hotelDetails.getPicture());
        hotel.setPhone(hotelDetails.getPhone());
        hotel.seteMail(hotelDetails.geteMail());
        hotel.setAddress(hotelDetails.getAddress());
        hotel.setPool(hotelDetails.isPool());
        hotel.setNightEntertainment(hotelDetails.isNightEntertainment());
        hotel.setRestaurant(hotelDetails.isRestaurant());
        hotel.setChildrenClub(hotelDetails.isChildrenClub());
        hotel.setDistanceToBeach(hotelDetails.getDistanceToBeach());
        hotel.setDistanceToCenter(hotelDetails.getDistanceToCenter());
        hotel.setPensionHalfPrice(hotelDetails.getPensionHalfPrice());
        hotel.setPensionFullPrice(hotelDetails.getPensionFullPrice());
        hotel.setAllInclusive(hotelDetails.getAllInclusive());

        final Hotel updatedHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(updatedHotel);
    }


    @DeleteMapping("/all")
    public void deleteAllHotels(@PathVariable long id){
      hotelRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteHotelById(@PathVariable long id) throws ResourceNotFoundException {
        Hotel hotel = getEntity(id);

        hotelRepository.delete(hotel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    private Hotel getEntity(Long id) throws ResourceNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + id));
    }

}
