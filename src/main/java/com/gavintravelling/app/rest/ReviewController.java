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
    public Iterable<Review> getAllReviews(){
            return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable long id){
    return reviewRepository.findById(id);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review){
     return reviewRepository.save(review);
    }


    @DeleteMapping("/all")
    public void deleteAllReviews(@PathVariable long id){
      reviewRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable long id){
      reviewRepository.deleteById(id);
    }

}
