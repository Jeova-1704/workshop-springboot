package com.workShop.work.shop.repositories;

import com.workShop.work.shop.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
