package com.V.FBasket.VnFBasket.dto;

public class OrderPlacedResponse {

    private Long orderId;
    private String message;

    public OrderPlacedResponse(Long orderId, String message) {
        this.orderId = orderId;
        this.message = message;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getMessage() {
        return message;
    }
}
