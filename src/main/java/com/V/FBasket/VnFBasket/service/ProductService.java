package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.model.Products;

public interface ProductService {
    Products addProducts(Products product, Long categoryId);
    List<Products> getAllProducts();
    Products getProductByProductName(String productName);
    List<Products> getProductsByCategoryId(Long categoryId);
    Products getProductById(Long productId);
    Products updateProduct(Products product, Long productId);
    boolean deleteProduct(Long productId);

    
} 
