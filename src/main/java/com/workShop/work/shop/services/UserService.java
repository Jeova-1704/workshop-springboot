package com.workShop.work.shop.services;

import com.workShop.work.shop.model.UserModel;
import com.workShop.work.shop.repositories.UserRepository;
import com.workShop.work.shop.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        userRepository.deleteById(id);
    }

    public UserModel update(long id, UserModel obj) {
        UserModel user = userRepository.getReferenceById(id);
        updateData(user, obj);
        return userRepository.save(user);
    }

    private void updateData(UserModel user, UserModel obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }
}
