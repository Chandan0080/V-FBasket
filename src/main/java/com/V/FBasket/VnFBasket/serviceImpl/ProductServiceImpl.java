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
    try{
        Products existingProduct = productsRepo.findById(productId).get();
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setProductRating(product.getProductRating());
        return productsRepo.save(existingProduct);

    }
    catch(Exception e){
        return null;
    }
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
    public List<Products> getProductsByCategoryName(String categoryName) {
        try{
            return productsRepo.findProductsByCategoryName(categoryName);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Products getProductByProductName(String productName) {
    try {
        return productsRepo.findByProductName(productName);
    } catch (Exception e) {
        return null;
    }
    }
    
}
