package com.V.FBasket.VnFBasket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String paymentType;
    private String paymentStatus;
    private String transactionId;

//    @OneToOne
//    @JoinColumn(name = "order_id", unique = true)
//    private Order order;


}
