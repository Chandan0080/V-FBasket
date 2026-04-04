package com.V.FBasket.VnFBasket.dto;


import lombok.Data;

import java.util.List;

@Data
public class CartResponseDTO {
    private Long cartId;
    private List<CartItemResponseDTO> items;
    private Double totalAmount;

    public CartResponseDTO(Long cartId, List<CartItemResponseDTO> items, Double totalAmount) {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = totalAmount;
    }
}
