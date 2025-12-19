package com.V.FBasket.VnFBasket.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.V.FBasket.VnFBasket.model.Order.Order;
import com.V.FBasket.VnFBasket.model.Order.OrderStatus;
import com.V.FBasket.VnFBasket.service.OrderService;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(
        @PathVariable Long id,
        @RequestParam OrderStatus status) {

     return ResponseEntity.ok(
         orderService.updateOrderStatus(id, status));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.cancelOrder(id));
    }
}
