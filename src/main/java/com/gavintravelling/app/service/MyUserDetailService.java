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

import javax.annotation.PostConstruct;

@Service
public class MyUserDetailService  implements UserDetailsService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public BCryptPasswordEncoder getEncoder(){
        return encoder;
    }

    @Autowired
    private CustomerRepository customerRepository;


    @PostConstruct
    private void addDefaultUser(){
        var customer = customerRepository.findByEMail("test@mail.com");
        if(customer == null){
            customer = new Customer("test@mail.com",getEncoder().encode("user"));
            customerRepository.save(customer);
        }


    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEMail(s);
        if(customer == null){
            throw new UsernameNotFoundException("Login failed");
        }

     return    toUserDetails(customer);
    }

    private UserDetails toUserDetails(Customer customer){
        return User.withUsername(customer.getEMail())
                .password(customer.getPassword())
                .roles("USER")
                .build();
    }
}
