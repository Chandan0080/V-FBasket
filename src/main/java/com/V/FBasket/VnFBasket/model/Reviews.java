package com.V.FBasket.VnFBasket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reviews {

    @Id
    @GeneratedValue
    private Long reviewId;
    private Long rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;
}
