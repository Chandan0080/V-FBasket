package com.V.FBasket.VnFBasket.service;

import java.util.List;
import com.V.FBasket.VnFBasket.model.Order;

public interface OrderService {

    Order placeOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getOrdersByUserId(Long userId);
    Order updateOrderStatus(Long orderId, String status);
    void cancelOrder(Long orderId);

}
