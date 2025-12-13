package com.V.FBasket.VnFBasket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String imageUrl;
    private int stockQuantity;
    private int productRating;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Categories category;
}
