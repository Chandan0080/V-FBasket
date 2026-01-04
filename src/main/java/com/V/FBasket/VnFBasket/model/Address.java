package com.V.FBasket.VnFBasket.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String address;
    private String street;
    private String city;
    private String state;
    private String pinCode;
    private Boolean isDefault;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
