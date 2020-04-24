package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   Customer findByEMailIgnoreCase(String email);
   Customer findByEMailIgnoreCaseAndPassword(String EMail, String password);
   Customer findByTokenId(String tokenId);
}