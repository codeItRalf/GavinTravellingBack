package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.City;
import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest/customers")
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
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) throws ResourceNotFoundException {

        Customer customer = getEntity(id);
        return ResponseEntity.ok().body(customer);
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
    public Customer createCustomer(@Valid @RequestBody Customer customer){
     return cmrRepository.save(customer);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                              @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = getEntity(id);

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.seteMail(customerDetails.geteMail());
        customer.setPassword(customerDetails.getPassword());
        final Customer updatedCustomer = cmrRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      cmrRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCustomerById(@PathVariable long id) throws ResourceNotFoundException {

        Customer customer = getEntity(id);

        cmrRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Customer getEntity(Long id) throws ResourceNotFoundException {
        return cmrRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
    }
}
