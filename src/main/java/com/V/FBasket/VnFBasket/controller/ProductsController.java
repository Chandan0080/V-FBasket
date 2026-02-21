package com.V.FBasket.VnFBasket.controller;

import java.io.IOException;
import java.util.List;

import com.V.FBasket.VnFBasket.dto.ProductRequest;
import com.V.FBasket.VnFBasket.dto.ProductResponseDTO;
import com.V.FBasket.VnFBasket.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.V.FBasket.VnFBasket.model.Products;
import com.V.FBasket.VnFBasket.service.ProductService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/vnfbasket")
public class ProductsController {
    @Autowired
    private ProductService pService;

    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Products> addProduct(@ModelAttribute ProductRequest productRequest) throws IOException {
        try {
            Products p = pService.addProducts(productRequest, productRequest.getProductImage());
            if (p != null) {
                return ResponseEntity.ok(p);
            } else {
                return ResponseEntity.status(500).build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> p1 = pService.getAllProducts();
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

    @PutMapping(value = "/updateProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Products> updateProduct(@ModelAttribute ProductRequest productRequest)
            throws IOException {
        Products updatedProduct = pService.updateProduct(productRequest);
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
