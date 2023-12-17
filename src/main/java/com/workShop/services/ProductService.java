package com.workShop.services;

import com.workShop.infra.DatabaseException;
import com.workShop.domain.ProductModel;
import com.workShop.repositories.ProductRepository;
import com.workShop.infra.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(Long id) {
        Optional<ProductModel> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        try {
            ProductModel product = findById(id);
            productRepository.delete(product);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ProductModel update(Long id, ProductModel obj) {
        try {
            ProductModel produto = productRepository.getReferenceById(id);
            updateData(produto, obj);
            return productRepository.save(produto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(ProductModel product, ProductModel obj) {
        product.setName(obj.getName());
        product.setDescription(obj.getDescription());
        product.setPrice(obj.getPrice());
        product.setImgUrl(obj.getImgUrl());
    }
}
