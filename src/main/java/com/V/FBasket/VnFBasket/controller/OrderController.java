package com.V.FBasket.VnFBasket.controller;

import com.V.FBasket.VnFBasket.config.UserInfoUserDetails;
import com.V.FBasket.VnFBasket.dto.OrderResponseDTO;
import com.V.FBasket.VnFBasket.dto.PlaceOrderRequestDTO;
import com.V.FBasket.VnFBasket.dto.SendEmailRequestDTO;
import com.V.FBasket.VnFBasket.model.Orders;
import com.V.FBasket.VnFBasket.service.OrderService;

import com.V.FBasket.VnFBasket.util.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/vnfbasket")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private EmailClient emailClient;
   
   
    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody PlaceOrderRequestDTO request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoUserDetails user = (UserInfoUserDetails) authentication.getPrincipal();
        Long userId = user!=null ? user.getUserId() : null;

        Orders order = orderService.createOrder(userId, request.getAddressId());

        OrderResponseDTO response = new OrderResponseDTO(
                order.getOrderId(),
                order.getOrderStatus(),
                order.getPaymentStatus(),
                order.getTotalAmount(),
                order.getOrderDate()
        );

        try {
            SendEmailRequestDTO emailRequest = SendEmailRequestDTO.builder()
                    .requestId(UUID.randomUUID().toString())
                    .to(user.getUsername())
                    .templateCode("order-confirmation")
                    .correlationId("ORDCONF" + order.getOrderId())
                    .variables(Map.of(
                            "name", order.getUser().getFirstName(),
                            "orderId", order.getOrderId(),
                            "orderDate", order.getOrderDate(),
                            "amount", order.getTotalAmount()
                    ))
                    .build();
            emailClient.sendEmail(emailRequest);
        }catch(Exception e){
            e.printStackTrace();
        }

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
    @GetMapping("/getOrdersByUser")
    public ResponseEntity<List<Orders>> getOrdersByUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoUserDetails user = (UserInfoUserDetails) authentication.getPrincipal();
        Long userId = user!=null ? user.getUserId() : null;

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
