package com.V.FBasket.VnFBasket.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.jpaRepository.OrderItemRepository;
import com.V.FBasket.VnFBasket.model.Order.OrderItem;
import com.V.FBasket.VnFBasket.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }


}
