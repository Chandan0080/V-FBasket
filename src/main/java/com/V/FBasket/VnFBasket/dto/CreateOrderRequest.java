package com.V.FBasket.VnFBasket.dto;

import java.util.List;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long userId;
    private Double totalAmount;
    private List<OrderItemRequest> items;
}