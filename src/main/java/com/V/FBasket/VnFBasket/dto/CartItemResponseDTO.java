package com.V.FBasket.VnFBasket.dto;

import lombok.Data;

@Data
public class CartItemResponseDTO {
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Double totalPrice;
    private String productImageUrl;
    private int availableQuantity;
    

    public CartItemResponseDTO(Long productId, String productName, Double productPrice, Integer quantity, Double totalPrice, String productImageUrl, int availableQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = productPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productImageUrl = productImageUrl;
        this.availableQuantity = availableQuantity;
    }
}
