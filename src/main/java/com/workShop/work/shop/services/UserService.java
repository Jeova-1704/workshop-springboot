package com.workShop.work.shop.services;

import com.workShop.work.shop.controller.exception.DatabaseException;
import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.repositories.UserRepository;
import com.workShop.work.shop.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        Optional<UserModel> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            UserModel user = findById(id);
            userRepository.delete(user);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserModel update(Long id, UserModel obj) {
        try {
            UserModel user = userRepository.getReferenceById(id);
            updateData(user, obj);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(UserModel user, UserModel obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }
}
