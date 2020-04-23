package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   List<Customer> findCustomersByFirstNameContaining(String firstName);
   List<Customer> findCustomersByLastNameContaining(String lastName);
   boolean existsCustomerByEMailIgnoreCase(String EMail);
   Customer findByEMailIgnoreCase(String email);
   Customer findByEMailIgnoreCaseAndPassword(String EMail, String password);
}