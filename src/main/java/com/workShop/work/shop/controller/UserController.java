package com.workShop.work.shop.controller;

import com.workShop.work.shop.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserModel> findAll(){
        UserModel u = new UserModel(1L, "Jeova", "jeova@gmail.com", "0987654321", "12345");
        return ResponseEntity.ok().body(u);
    }
}
