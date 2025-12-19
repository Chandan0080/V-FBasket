package com.V.FBasket.VnFBasket.serviceImpl;
import java.time.LocalDateTime;
import java.util.List;  
import org.springframework.stereotype.Service;
import com.V.FBasket.VnFBasket.model.Order.Order;
import com.V.FBasket.VnFBasket.model.Order.OrderItem;
import com.V.FBasket.VnFBasket.model.Order.OrderStatus;
import com.V.FBasket.VnFBasket.model.Order.PaymentStatus;
import com.V.FBasket.VnFBasket.jpaRepository.OrderRepository;
import com.V.FBasket.VnFBasket.service.OrderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {

        order.setOrderStatus(OrderStatus.PLACED);
        order.setPaymentStatus(PaymentStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                item.setOrder(order);
            }
        }

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
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