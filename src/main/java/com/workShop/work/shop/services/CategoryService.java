package com.workShop.work.shop.services;

import com.workShop.work.shop.model.CategoryModel;
import com.workShop.work.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel findById(Long id) {
        Optional<CategoryModel> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
