package com.V.FBasket.VnFBasket.serviceImpl;

import com.V.FBasket.VnFBasket.jpaRepository.OrderItemsRepository;
import com.V.FBasket.VnFBasket.model.OrderItems;
import com.V.FBasket.VnFBasket.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItems addOrderItem(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Override
    public List<OrderItems> getOrderItemsByOrderId(Long orderId) {
        return orderItemsRepository.findByOrder_OrderId(orderId);
    }
}
