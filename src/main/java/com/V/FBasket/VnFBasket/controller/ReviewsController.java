package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.serviceImpl.ReviewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {

    @Autowired
    private ReviewsServiceImpl reviewsService;
}
