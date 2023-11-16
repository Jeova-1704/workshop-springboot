package com.workShop.work.shop.services;

import com.workShop.work.shop.model.ProductModel;
import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.repositories.ProductRepository;
import com.workShop.work.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }
}
