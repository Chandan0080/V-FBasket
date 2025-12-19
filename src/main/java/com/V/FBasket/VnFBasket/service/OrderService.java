package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.Order.Order;
import com.V.FBasket.VnFBasket.model.Order.OrderStatus;

public interface OrderService {

    Order placeOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUser(Long userId);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    Order cancelOrder(Long orderId);

    
}