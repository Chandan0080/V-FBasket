package com.V.FBasket.VnFBasket.model.Order;

import jakarta.persistence.*;   
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false) /// hum bina iske bhi kaam chla skte h hatana h to hata dena bas isko likne se null data nhi lega db me kuch bhi.
    private Long userId;

    @Column(name = "total_amount", nullable = false)  // same for this 
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime createdAt;

    // One Order → Many OrderItems   --> ye vs code ka suggestion h jo maine accept kar liya h
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    // Address ID for the order
    @Column(name = "address_id", nullable = false)
    private Long addressId;

}