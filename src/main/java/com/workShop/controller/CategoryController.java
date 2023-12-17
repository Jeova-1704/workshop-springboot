package com.workShop.controller;

import com.workShop.domain.CategoryModel;
import com.workShop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<CategoryModel> insertOrder(@RequestBody CategoryModel category) {
        CategoryModel novaCategoty = categoryService.saveCategory(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCategoty.getId()).toUri();
        return ResponseEntity.created(uri).body(novaCategoty);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryModel> update(@PathVariable Long id, @RequestBody CategoryModel category) {
        category = categoryService.update(id, category);
        return ResponseEntity.ok().body(category);
    }
}
