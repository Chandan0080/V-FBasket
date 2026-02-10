package com.V.FBasket.VnFBasket.controller;

import java.util.List;

import com.V.FBasket.VnFBasket.dto.ProductRequest;
import com.V.FBasket.VnFBasket.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.service.ProductService;


@RestController
@RequestMapping("/vnfbasket")
public class ProductsController {
    @Autowired
    private ProductService pService;

    @PostMapping("/addProduct")
    public ResponseEntity<Products> addProduct(@RequestBody ProductRequest productRequest){
        Products p = pService.addProducts(productRequest);
        if(p!=null){
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> p1 = pService.getAllProducts();
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getProductsById/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable Long id){
        Products p1 = pService.getProductById(id);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getProductsByCategoryId/{id}")
    public ResponseEntity<List<Products>> getProductsByCategoryId(@PathVariable Long id){
        List<Products> p1 = pService.getProductsByCategoryId(id);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getProductByProductName/{name}")
    public ResponseEntity<Products> getProductByProductName(@PathVariable String name){
        Products p1 = pService.getProductByProductName(name);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/deleteProduct/{productId}")
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

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Products> updateProduct(@RequestBody Products product, @PathVariable long productId) {
        Products updatedProduct = pService.updateProduct(product, productId);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductsByCategoryName/{categoryName}")
    public ResponseEntity<List<Products>> getProductsByCategoryName(@PathVariable String categoryName){
        List<Products> p1 = pService.getProductsByCategoryName(categoryName);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }
    
}
