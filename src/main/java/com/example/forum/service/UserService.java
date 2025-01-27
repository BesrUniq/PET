package com.example.forum.service;

import com.example.forum.models.User;
import com.example.forum.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(String username, String password, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Имя пользователя уже занято");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Электронная почта уже используется");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        System.out.println("Сохранение пользователя в базу...");
        User savedUser = userRepository.save(user);
        System.out.println("Пользователь сохранен с ID: " + savedUser.getId());

        return savedUser;
    }



    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}



