package com.V.FBasket.VnFBasket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductsController {
    @Autowired
    private ProductService pService;

    @PostMapping("/category/{categoryId}/product")
    public ResponseEntity<Products> addProduct(@RequestBody Products product,@PathVariable Long categoryId){
        Products p = pService.addProducts(product, categoryId);
        if(p!=null){
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> p1 = pService.getAllProducts();
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable Long id){
        Products p1 = pService.getProductById(id);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/products/category/{id}")
    public ResponseEntity<List<Products>> getProductsByCategoryId(@PathVariable Long id){
        List<Products> p1 = pService.getProductsByCategoryId(id);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<Products> getProductByProductName(@PathVariable String name){
        Products p1 = pService.getProductByProductName(name);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

        @DeleteMapping("/product/{productId}")
    public ResponseEntity<Products> deleteProduct(@PathVariable long productId) {
        Products product = pService.getProductById(productId);
        if(product!=null && pService.deleteProduct(
                productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
