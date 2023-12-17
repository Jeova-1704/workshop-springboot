package com.workShop.repositories;

import com.workShop.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long>{

}
