package com.practice.microservices.user.service.services.impl;

import com.practice.microservices.user.service.entities.User;
import com.practice.microservices.user.service.exceptions.ResourceNotFoundException;
import com.practice.microservices.user.service.repository.UserRepository;
import com.practice.microservices.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not found With Id: "+ userId));
    }
}
