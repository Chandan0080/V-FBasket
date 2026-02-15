package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.dto.OrderResponseDTO;
import com.V.FBasket.VnFBasket.model.Orders;
import com.V.FBasket.VnFBasket.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vnfbasket")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
   
   
    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestParam Long userId, @RequestParam Long addressId) {

        Orders order = orderService.createOrder(userId, addressId);

        OrderResponseDTO response = new OrderResponseDTO(
                order.getOrderId(),
                order.getOrderStatus(),
                order.getPaymentStatus(),
                order.getTotalAmount(),
                order.getOrderDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Get Order By Id
     * GET
     */
    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<Orders> getOrderById(
            @PathVariable Long orderId) {

        Orders order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    /**
     * Get All Orders of a User
     * GET
     */
    @GetMapping("/getOrdersByUser/{userId}")
    public ResponseEntity<List<Orders>> getOrdersByUser(
            @PathVariable Long userId) {

        List<Orders> orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }

    /**
     * Cancel Order
     * PUT
     */
    @PutMapping("/cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(
            @PathVariable Long orderId) {

        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order cancelled successfully");
    }
}
