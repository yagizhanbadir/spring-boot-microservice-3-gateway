package com.yb.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.yb.springbootmicroservice3gateway.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("save")
    public ResponseEntity<?> saveProduct(@RequestBody JsonElement product){
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @DeleteMapping("delete/{productId}")
    public ResponseEntity<?> saveProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
