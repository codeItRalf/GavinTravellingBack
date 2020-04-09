package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstName(String firstName);
    Customer findByLastName(String surname);
    List<Customer> findAllByFirstName(String name);
}