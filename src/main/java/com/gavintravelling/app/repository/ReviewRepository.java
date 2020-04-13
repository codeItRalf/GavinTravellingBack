package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}