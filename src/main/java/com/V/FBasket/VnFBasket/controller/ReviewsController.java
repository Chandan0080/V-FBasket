package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.model.Reviews;
import com.V.FBasket.VnFBasket.serviceImpl.ReviewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsServiceImpl reviewsService;

    @PostMapping("/addReview/{userId}/{productId}")
    public ResponseEntity<Reviews> addReview(@RequestBody Reviews review, @PathVariable Long userId, @PathVariable Long productId) {
        Reviews addReview = reviewsService.addReview(review, userId, productId);
        if(addReview!=null){
            return new ResponseEntity<>(addReview, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Reviews>> getReviewsByProductId(@PathVariable Long productId) {
        List<Reviews> reviewsList = reviewsService.getReviewByProductId(productId);
        if(reviewsList!=null){
            return new ResponseEntity<>(reviewsList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reviews>> getReviewsByUserId(@PathVariable Long userId) {
        List<Reviews> reviewsList = reviewsService.getReviewByUserId(userId);
        if (reviewsList != null) {
            return new ResponseEntity<>(reviewsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateReviews/{reviewId}")
    public ResponseEntity<Reviews> updateReview(@RequestBody Reviews review, @PathVariable Long reviewId) {
        Reviews updatedReview = reviewsService.updateReview(review, reviewId);
        if (updatedReview != null) {
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteReviews/{reviewId}")
    public ResponseEntity<Reviews> deleteReview(@PathVariable Long reviewId) {
        Boolean deleteReview = reviewsService.deleteReview(reviewId);
        if (deleteReview) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
