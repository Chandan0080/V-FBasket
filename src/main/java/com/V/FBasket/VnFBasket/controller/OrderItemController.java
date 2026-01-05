package com.V.FBasket.VnFBasket.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;


import com.V.FBasket.VnFBasket.model.Order.OrderItem;
import com.V.FBasket.VnFBasket.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getItemsByOrder(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrderId(orderId);
    }
    
    
}
