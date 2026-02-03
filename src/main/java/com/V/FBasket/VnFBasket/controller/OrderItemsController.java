package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.model.OrderItems;
import com.V.FBasket.VnFBasket.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems/")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping
    public OrderItems addOrderItem(@RequestBody OrderItems orderItems) {
        return orderItemsService.addOrderItem(orderItems);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItems> getItemsByOrderId(@PathVariable Long orderId) {
        return orderItemsService.getOrderItemsByOrderId(orderId);
    }

    
}
