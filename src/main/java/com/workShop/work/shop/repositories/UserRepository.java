package com.workShop.work.shop.repositories;

import com.workShop.work.shop.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{
}
