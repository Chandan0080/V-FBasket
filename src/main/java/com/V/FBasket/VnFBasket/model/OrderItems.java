package com.V.FBasket.VnFBasket.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Orders order;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Products product;

    private Integer quantity;
    private Long price;
    
}
