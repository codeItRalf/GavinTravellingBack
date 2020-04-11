package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.City;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;




    @GetMapping
    public Iterable<City> getAllCities(){
            return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<City> getCityById(@PathVariable long id){
    return cityRepository.findById(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city){
     return cityRepository.save(city);
    }


    @DeleteMapping("/all")
    public void deleteAllCities(@PathVariable long id){
      cityRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable long id){
      cityRepository.deleteById(id);
    }

}
