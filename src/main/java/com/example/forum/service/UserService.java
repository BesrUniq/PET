package com.example.forum.service;

import com.example.forum.models.User;
import com.example.forum.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User save(User user) {
        return userRepository.save(user);
    }
}

