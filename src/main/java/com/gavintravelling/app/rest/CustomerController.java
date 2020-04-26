package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.TokenId;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest/customers")
public class CustomerController {


   private CustomerRepository customerRepository;
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerController(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers(){
            return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) throws ResourceNotFoundException {

        Customer customer = getEntity(id);
        return ResponseEntity.ok().body(customer);
    }



    @PostMapping("/sign-up")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
     return customerRepository.save(customer);
    }

    @PostMapping("/user")
    public ResponseEntity<Customer> authCustomer(@Valid @RequestBody TokenId tokenId){
        return ResponseEntity.ok(customerRepository.findByTokenId(tokenId.getToken()));
    }



    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                              @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = getEntity(id);


        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.seteEMail(customerDetails.geteEMail());
        customer.setPassword(customerDetails.getPassword());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      customerRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCustomerById(@PathVariable long id) throws ResourceNotFoundException {

        Customer customer = getEntity(id);

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Customer getEntity(Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
    }
}
