package com.workShop.work.shop.services;

import com.workShop.work.shop.controller.exception.DatabaseException;
import com.workShop.work.shop.model.OrderModel;
import com.workShop.work.shop.repositories.OrderRepository;
import com.workShop.work.shop.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.grammars.ordering.OrderingLexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public OrderModel saveOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        try {
            OrderModel order = findById(id);
            orderRepository.delete(order);
        } catch (EmptyResultDataAccessException  e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public OrderModel updateOrder(Long id, OrderModel obj) {
        try {
            OrderModel order = orderRepository.getReferenceById(id);
            updateData(order, obj);
            return orderRepository.save(order);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(OrderModel order, OrderModel obj) {
        order.setMoment(obj.getMoment());
        order.setOrderStatus(obj.getOrderStatus());
        order.setClient(obj.getClient());
        order.setPaymentModel(obj.getPaymentModel());
    }
}
