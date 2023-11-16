package com.workShop.work.shop.controller;

import com.workShop.work.shop.model.ProductModel;
import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.services.ProductService;
import com.workShop.work.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll(){
        List<ProductModel> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        ProductModel product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
