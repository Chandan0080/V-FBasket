package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.PaymentsRepository;
import com.V.FBasket.VnFBasket.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsSeviceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

}
