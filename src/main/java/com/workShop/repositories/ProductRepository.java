package com.workShop.repositories;

import com.workShop.domain.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
