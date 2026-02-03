package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.DTO.OrderPlacedResponse;
import com.V.FBasket.VnFBasket.model.Orders;
import com.V.FBasket.VnFBasket.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
   
   
    @PostMapping
    public OrderPlacedResponse placeOrder(@RequestBody Orders order) {
         if (order.getAddress() == null) 
        {
           throw new ResponseStatusException( HttpStatus.BAD_REQUEST,"Address is required to place order");
        }

       Orders savedOrder = orderService.placeOrder(order);
        return new OrderPlacedResponse(
        savedOrder.getOrderId(),
        "Order placed successfully");
    }

    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
    
    @GetMapping("/user/{userId}")
    public List<Orders> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PutMapping("/{orderId}/status")
    public Orders updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {

        return orderService.updateOrderStatus(orderId, status);
    }

    
    @DeleteMapping("/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return "Order cancelled successfully";
    }
}
