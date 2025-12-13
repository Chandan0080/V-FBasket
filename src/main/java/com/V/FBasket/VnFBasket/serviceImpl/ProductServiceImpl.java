package com.V.FBasket.VnFBasket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.jpaRepository.CategoriesRepository;
import com.V.FBasket.VnFBasket.jpaRepository.ProductsRepository;
import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
private ProductsRepository productsRepo;

@Autowired
private CategoriesRepository categoryryRepo;

@Override
public Products addProducts(Products product, Long categoryId) {
    try {
        product.setCategory(categoryryRepo.findById(categoryId).get());
        return productsRepo.save(product);
    } catch (Exception e) {
        return null;
    }
}

@Override
public List<Products> getAllProducts() {
    try {
        return productsRepo.findAll();
    } catch (Exception e) {
        return null;
    }
}

@Override
public List<Products> getProductsByCategoryId(Long categoryId) {
  try{
    return productsRepo.findByCategoryCategoryId(categoryId);
  } catch (Exception e) {
        return null;
    }
}

@Override
public Products getProductById(Long productId) {
    try {
        return productsRepo.findById(productId).get();
    } catch (Exception e) {
        return null;
    }
}

@Override
public Products updateProduct(Products product, Long productId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
}

@Override
public boolean deleteProduct(Long productId) {
    try {
        productsRepo.deleteById(productId);
        return true;
    } catch (Exception e) {
        return false;
    }
}

@Override
public Products getProductByProductName(String productName) {
    try {
        return productsRepo.findByProductName(productName).get(0);
    } catch (Exception e) {
        return null;
    }
}


    
}
