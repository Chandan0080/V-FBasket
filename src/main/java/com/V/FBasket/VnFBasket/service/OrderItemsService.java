package com.V.FBasket.VnFBasket.service;

import com.V.FBasket.VnFBasket.model.OrderItems;
import java.util.List;

public interface OrderItemsService {

    OrderItems addOrderItem(OrderItems orderItems);

    List<OrderItems> getOrderItemsByOrderId(Long orderId);
}
