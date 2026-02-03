package com.V.FBasket.VnFBasket.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.jpaRepository.OrderRepository;
import com.V.FBasket.VnFBasket.model.Orders;
import com.V.FBasket.VnFBasket.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders placeOrder(Orders order) {
        order.setOrderStatus("PLACED");
        order.setPaymentStatus("SUCCESS");
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Override
    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Orders> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId); // address fetched via JOIN FETCH
    }

    @Override
    public Orders updateOrderStatus(Long orderId, String status) {
        Orders order = getOrderById(orderId);
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        Orders order = getOrderById(orderId);
        order.setOrderStatus("CANCELLED");
        orderRepository.save(order);
    }
}
