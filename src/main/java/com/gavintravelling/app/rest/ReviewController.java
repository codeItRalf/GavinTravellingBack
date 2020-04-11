package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Review;
import com.gavintravelling.app.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;




    @GetMapping
    public Iterable<Review> getAllCustomers(){
            return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Review> getCustomerById(@PathVariable long id){
    return reviewRepository.findById(id);
    }

    @PostMapping
    public Review createCustomer(@RequestBody Review review){
     return reviewRepository.save(review);
    }


    @DeleteMapping("/all")
    public void deleteAllCustomers(@PathVariable long id){
      reviewRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable long id){
      reviewRepository.deleteById(id);
    }

}
