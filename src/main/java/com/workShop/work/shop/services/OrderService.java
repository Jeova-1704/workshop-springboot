package com.workShop.work.shop.services;

import com.workShop.work.shop.model.OrderModel;
import com.workShop.work.shop.repositories.OrderRepository;
import com.workShop.work.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    public OrderModel findById(Long id) {
        Optional<OrderModel> obj = orderRepository.findById(id);
        return obj.get();
    }
}
