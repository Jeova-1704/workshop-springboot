package com.workShop.work.shop.repositories;

import com.workShop.work.shop.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
