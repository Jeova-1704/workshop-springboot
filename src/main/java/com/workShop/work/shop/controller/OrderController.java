package com.workShop.work.shop.controller;

import com.workShop.work.shop.model.OrderModel;
import com.workShop.work.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> findAll(){
        List<OrderModel> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderModel> findById(@PathVariable Long id) {
        OrderModel order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    public ResponseEntity<OrderModel> insertOrder(@RequestBody OrderModel order) {
        OrderModel novoOrder = orderService.saveOrder(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoOrder.getId()).toUri();
        return ResponseEntity.created(uri).body(novoOrder);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderModel> update(@PathVariable Long id, @RequestBody OrderModel order) {
        order = orderService.updateOrder(id, order);
        return ResponseEntity.ok().body(order);
    }
}
