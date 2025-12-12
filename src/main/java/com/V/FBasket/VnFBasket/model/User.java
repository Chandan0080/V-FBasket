package com.V.FBasket.VnFBasket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private String phoneNumber;
    private String role;
}
