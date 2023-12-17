package com.workShop.repositories;

import com.workShop.domain.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

}
