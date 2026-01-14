package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.Orders;

public interface OrderService {

    Orders placeOrder(Orders order);
    Orders getOrderById(Long orderId);
    List<Orders> getOrdersByUserId(Long userId);
    Orders updateOrderStatus(Long orderId, String status);
    void cancelOrder(Long orderId);

}
