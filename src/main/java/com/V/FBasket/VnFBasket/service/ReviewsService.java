package com.V.FBasket.VnFBasket.service;

import com.V.FBasket.VnFBasket.model.Reviews;

import java.util.List;

public interface ReviewsService {

    Reviews addReview(Reviews review, Long userId, Long productId);
    List<Reviews> getReviewByProductId(Long productId);
    List<Reviews> getReviewByUserId(Long userId);
    Reviews updateReview(Reviews review, Long reviewId);
    Boolean deleteReview(Long reviewId);
}
