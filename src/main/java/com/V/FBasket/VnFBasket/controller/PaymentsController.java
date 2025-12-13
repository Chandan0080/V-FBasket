package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.serviceImpl.PaymentsSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsSeviceImpl paymentsSeviceImpl;


}
