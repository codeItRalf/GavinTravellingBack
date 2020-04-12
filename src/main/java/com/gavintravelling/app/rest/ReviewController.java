package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Review;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;




    @GetMapping
    public Iterable<Review> getAllReviews(){
            return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable long id) throws ResourceNotFoundException {
        Review review = getEntity(id);
        return ResponseEntity.ok().body(review);
    }

    @PostMapping
    public Review createReview(@Valid @RequestBody Review review){
     return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id,
                                             @Valid @RequestBody Review reviewDetails) throws ResourceNotFoundException {
        Review review = getEntity(id);

        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());

        final Review updatedReview = reviewRepository.save(review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/all")
    public void deleteAllReviews(@PathVariable long id){
      reviewRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteReviewById(@PathVariable long id) throws ResourceNotFoundException {
        Review review = getEntity(id);

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Review getEntity(Long id) throws ResourceNotFoundException {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + id));
    }

}
