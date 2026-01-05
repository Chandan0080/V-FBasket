package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.ProductsRepository;
import com.V.FBasket.VnFBasket.jpaRepository.ReviewsRepository;
import com.V.FBasket.VnFBasket.jpaRepository.UserRepository;
import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.model.Reviews;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Reviews addReview(Reviews review, Long userId, Long productId) {
        try{
            User user = userRepository.findById(userId).orElse(null);
            Products product = productsRepository.findById(productId).orElse(null);
            if(user == null || product == null){
                return null;
            }
            review.setUser(user);
            review.setProduct(product);
            return reviewsRepository.save(review);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

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
    public Reviews updateReview(Reviews review, Long reviewId) {
        try {
            Reviews existingReview = reviewsRepository.findById(reviewId).orElse(null);
            if (existingReview != null) {
                existingReview.setRating(review.getRating());
                existingReview.setComment(review.getComment());
                return reviewsRepository.save(existingReview);
            } else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteReview(Long reviewId) {
        try{
            reviewsRepository.deleteById(reviewId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
