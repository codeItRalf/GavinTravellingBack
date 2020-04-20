package com.gavintravelling.app.service;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public BCryptPasswordEncoder getEncoder(){
        return encoder;
    }

    @Autowired
    private CustomerRepository customerRepository;


    @PostConstruct
    private void addDefaultUser(){
        var customer = customerRepository.findByEMailIgnoreCase("test@mail.com");
        if(customer == null){
            customer = new Customer("test@mail.com",getEncoder().encode("user"));
            customerRepository.save(customer);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEMailIgnoreCase(s);
        if(customer == null){
            throw new UsernameNotFoundException("Login failed");
        }

     return    toUserDetails(customer);
    }

    public void addCustomer(Customer customer){
        var c = new Customer(customer.getFirstName(), customer.getLastName(),customer.getPhoneNumber(),customer.getEMail(),customer.getPersonNumber(), getEncoder().encode(customer.getPassword()));
        try {
            customerRepository.save(c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private UserDetails toUserDetails(Customer customer){
        return User.withUsername(customer.getEMail())
                .password(customer.getPassword())
                .roles("USER")
                .build();
    }
}
