package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Booking;
import com.gavintravelling.app.entity.City;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/rest/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;




    @GetMapping
    public Iterable<City> getAllCities(){
            return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable long id) throws ResourceNotFoundException {

        City city = getEntity(id);
        return ResponseEntity.ok().body(city);
    }

    @PostMapping
    public City createCity(@Valid @RequestBody City city){
     return cityRepository.save(city);
    }


    @PutMapping("/{id}")
    public ResponseEntity<City> updateBooking(@PathVariable Long id,
                                                 @Valid @RequestBody City cityDetails) throws ResourceNotFoundException {
        City city = getEntity(id);

        city.setName(cityDetails.getName());
        final City updatedCity = cityRepository.save(city);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/all")
    public void deleteAllCities(@PathVariable long id){
      cityRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCityById(@PathVariable long id) throws ResourceNotFoundException {
        City city = getEntity(id);

        cityRepository.delete(city);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    private City getEntity(Long id) throws ResourceNotFoundException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + id));
    }
}
