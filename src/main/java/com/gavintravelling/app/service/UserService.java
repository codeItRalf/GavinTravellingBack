package com.gavintravelling.app.service;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public Customer findCurrentUser(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return customerRepository.findByEMailIgnoreCase(userName);
    }



    public boolean customerAlreadyExistsByEmail(String email){
        return customerRepository.existsCustomerByEMailIgnoreCase(email);
    }

    public Customer RegisterUser(Customer customer){
        return myUserDetailsService.addCustomer(customer);
    }

}
