package com.workShop.work.shop.controller;

import com.workShop.work.shop.model.CategoryModel;
import com.workShop.work.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> findAll(){
        List<CategoryModel> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryModel> findById(@PathVariable Long id) {
        CategoryModel category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
