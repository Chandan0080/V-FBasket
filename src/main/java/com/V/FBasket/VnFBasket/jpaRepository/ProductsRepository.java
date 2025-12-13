package com.V.FBasket.VnFBasket.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.V.FBasket.VnFBasket.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {

    List<Products> findByCategoryCategoryId(Long categoryId);
    List<Products> findByProductName(String productName);
    
} 
