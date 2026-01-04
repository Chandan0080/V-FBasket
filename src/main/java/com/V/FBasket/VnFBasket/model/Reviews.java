package com.V.FBasket.VnFBasket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name="user_id", unique = true, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id", unique = true, nullable = false)
    private Products product;
}
