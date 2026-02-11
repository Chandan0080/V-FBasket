package com.V.FBasket.VnFBasket.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String imageUrl;
    private int stockQuantity;
    private int productRating;
    private Long categoryId;

    
}
