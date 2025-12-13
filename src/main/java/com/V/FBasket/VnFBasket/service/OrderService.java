package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.order.Order;
import com.V.FBasket.VnFBasket.model.order.OrderStatus;

public interface OrderService {

    Order placeOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getOrdersByUser(Long userId);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    Order cancelOrder(Long orderId);
}
