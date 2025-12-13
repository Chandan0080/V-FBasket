package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartServiceImpl cartService;
}
