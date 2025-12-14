package com.V.FBasket.VnFBasket.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.dto.CreateOrderRequest;
import com.V.FBasket.VnFBasket.dto.OrderItemRequest;
import com.V.FBasket.VnFBasket.jpaRepository.OrderRepository;
import com.V.FBasket.VnFBasket.model.order.Order;
import com.V.FBasket.VnFBasket.model.order.OrderItem;
import com.V.FBasket.VnFBasket.model.order.OrderStatus;
import com.V.FBasket.VnFBasket.model.order.PaymentStatus;
import com.V.FBasket.VnFBasket.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(CreateOrderRequest request) {

        // 1️⃣ Create Order (parent)
        Order order = Order.builder()
                .userId(request.getUserId())
                .totalAmount(request.getTotalAmount())
                .orderStatus(OrderStatus.PLACED)
                .paymentStatus(PaymentStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        // 2️⃣ Create OrderItems (children)
        List<OrderItem> orderItems = request.getItems()
                .stream()
                .map(item -> buildOrderItem(item, order))
                .toList();

        // 3️⃣ Attach items to order
        order.setItems(orderItems);

        // 4️⃣ Save order → cascades to order_items
        return orderRepository.save(order);
    }

    private OrderItem buildOrderItem(OrderItemRequest item, Order order) {
        return OrderItem.builder()
                .productId(item.getProductId())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .order(order) // 🔥 MOST IMPORTANT LINE
                .build();
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
