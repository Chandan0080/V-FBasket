package com.V.FBasket.VnFBasket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long addressId;
    private String address;
    private String street;
    private String city;
    private String state;
    private String pinCode;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
}
