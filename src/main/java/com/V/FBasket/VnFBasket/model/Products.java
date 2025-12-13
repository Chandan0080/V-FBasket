package com.V.FBasket.VnFBasket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Reviews> reviews = new ArrayList<>();
}
