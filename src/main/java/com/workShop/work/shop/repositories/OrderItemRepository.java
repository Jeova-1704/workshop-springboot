package com.workShop.work.shop.repositories;

import com.workShop.work.shop.model.OrderItem;
import com.workShop.work.shop.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
