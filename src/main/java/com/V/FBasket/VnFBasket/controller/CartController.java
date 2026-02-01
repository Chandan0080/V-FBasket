package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;
}
