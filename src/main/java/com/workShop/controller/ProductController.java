package com.workShop.controller;

import com.workShop.services.ProductService;
import com.workShop.domain.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ProductModel> insertProduct(@RequestBody ProductModel product) {
        ProductModel novoProduto = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(novoProduto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel product) {
        product = productService.update(id, product);
        return ResponseEntity.ok().body(product);
    }
}
