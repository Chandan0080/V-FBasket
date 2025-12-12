package com.V.FBasket.VnFBasket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categories {

    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
