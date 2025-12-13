package com.V.FBasket.VnFBasket.serviceImpl;
import com.V.FBasket.VnFBasket.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.model.order.Order;
import com.V.FBasket.VnFBasket.model.order.OrderStatus;
import com.V.FBasket.VnFBasket.model.order.PaymentStatus;
import lombok.RequiredArgsConstructor;
import com.V.FBasket.VnFBasket.jpaRepository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        order.setOrderStatus(OrderStatus.PLACED);
        order.setPaymentStatus(PaymentStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public Order cancelOrder(Long orderId) {
        Order order = getOrderById(orderId);
        order.setOrderStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
}
