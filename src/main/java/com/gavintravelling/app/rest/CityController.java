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
    public Iterable<City> getAllCustomers(){
            return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<City> getCustomerById(@PathVariable long id){
    return cityRepository.findById(id);
    }

    @PostMapping
    public City createCustomer(@RequestBody City city){
     return cityRepository.save(city);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      cityRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      cityRepository.deleteById(id);
    }

}
