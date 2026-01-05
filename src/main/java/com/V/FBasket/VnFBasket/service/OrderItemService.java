package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.Order.OrderItem;

public interface OrderItemService {
    List<OrderItem> getItemsByOrderId(Long orderId);
   
}
