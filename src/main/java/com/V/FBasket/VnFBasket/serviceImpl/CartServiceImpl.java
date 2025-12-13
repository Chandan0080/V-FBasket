package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.CartRepository;
import com.V.FBasket.VnFBasket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
}
