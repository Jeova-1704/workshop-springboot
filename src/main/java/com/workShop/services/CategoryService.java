package com.workShop.services;

import com.workShop.infra.DatabaseException;
import com.workShop.infra.ResourceNotFoundException;
import com.workShop.domain.CategoryModel;
import com.workShop.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public CategoryModel saveCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        try {
            CategoryModel category = findById(id);
            categoryRepository.delete(category);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public CategoryModel update(Long id, CategoryModel obj) {
        try {
            CategoryModel category = categoryRepository.getReferenceById(id);
            updateData(category, obj);
            return categoryRepository.save(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(CategoryModel category, CategoryModel obj) {
        category.setName(obj.getName());
    }
}
