package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository cmrRepository;


    public CustomerController() {
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers(){
            return cmrRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable long id){
    return cmrRepository.findById(id);
    }

    @GetMapping("firstName={searchValue}")
    public Iterable<Customer> findCustomersByFirstName(@PathVariable String searchValue){
        return cmrRepository.findCustomersByFirstNameContaining(searchValue);
    }

    @GetMapping("lastName={searchValue}")
    public Iterable<Customer> findCustomersByLastName(@PathVariable String searchValue){
        return cmrRepository.findCustomersByLastNameContaining(searchValue);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
     return cmrRepository.save(customer);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      cmrRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      cmrRepository.deleteById(id);
    }

    @GetMapping("logout")
    public String logOut(){
        return "You have logged out!";
    }
}
