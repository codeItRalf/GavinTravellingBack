package com.gavintravelling.app.service;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
        private CustomerRepository customerRepository;
        private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    private void addDefaultUser(){
        var customer = customerRepository.findByEMailIgnoreCase("user@mail.com");
        if(customer == null){
            customer = new Customer("user@mail.com",bCryptPasswordEncoder.encode("password"));
            customerRepository.save(customer);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer applicationUser = customerRepository.findByEMailIgnoreCase(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.geteEMail(), applicationUser.getPassword(), emptyList());
    }

}
