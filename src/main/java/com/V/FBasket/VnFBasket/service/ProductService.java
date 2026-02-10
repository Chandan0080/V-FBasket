package com.V.FBasket.VnFBasket.service;

import java.util.List;

import com.V.FBasket.VnFBasket.dto.ProductRequest;
import com.V.FBasket.VnFBasket.model.Products;

public interface ProductService {
    Products addProducts(ProductRequest productRequest);
    List<Products> getAllProducts();
    Products getProductByProductName(String productName);
    List<Products> getProductsByCategoryId(Long categoryId);
    Products getProductById(Long productId);
    Products updateProduct(Products product, Long productId);
    boolean deleteProduct(Long productId);
    List<Products> getProductsByCategoryName(String categoryName);

    
} 
