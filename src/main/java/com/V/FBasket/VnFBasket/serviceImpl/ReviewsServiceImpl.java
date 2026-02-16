package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.ProductsRepository;
import com.V.FBasket.VnFBasket.jpaRepository.ReviewsRepository;
import com.V.FBasket.VnFBasket.jpaRepository.UserRepository;
import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.model.Reviews;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.ReviewsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    @Transactional
    public Reviews addReview(User user, Long productId, Long rating, String comment) {
        Products product = productsRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        Reviews review = new Reviews();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(rating);
        review.setComment(comment);
        Reviews savedReview = reviewsRepository.save(review);
        updateProductRating(productId);
        return savedReview;

    }

    @Override
    public List<Reviews> getReviewByProductId(Long productId) {
        try{
            return reviewsRepository.findReviewsByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reviews> getReviewByUserId(Long userId) {
        try{
            return reviewsRepository.findReviewsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public Reviews updateReview(Long reviewId, Long userId, Long rating, String comment) throws AccessDeniedException {
        Reviews review = reviewsRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        if(!review.getUser().getUserId().equals(userId)){
            throw new AccessDeniedException("Unauthorized to update this review");
        }
        review.setRating(rating);
        review.setComment(comment);
        Reviews updatedReview = reviewsRepository.save(review);
        updateProductRating(review.getProduct().getProductId());
        return updatedReview;


    }

    @Override
    @Transactional
    public void deleteReview(Long reviewId, Long userId) throws AccessDeniedException {
        Reviews review = reviewsRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        if(!review.getUser().getUserId().equals(userId)){
            throw new AccessDeniedException("Unauthorized to delete this review");
        }
        reviewsRepository.delete(review);
        updateProductRating(review.getProduct().getProductId());

    }

    private void updateProductRating(Long productId) {
        Products product = productsRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        Integer averageRating = reviewsRepository.findAverageRatingByProductId(productId);
        product.setProductRating(averageRating!=null ? averageRating : 0);
    }
}
