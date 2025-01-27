package com.example.forum.controller;

import com.example.forum.models.User;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               Model model) {
        try {
            System.out.println("Регистрация пользователя: " + username);
            userService.registerUser(username, password, email);
            System.out.println("Регистрация успешна, перенаправление...");
            return "redirect:/";
        } catch (Exception e) {
            System.err.println("Ошибка при регистрации: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        try {
            User user = userService.findByUsername(username);
            if (user.getPassword().equals(password)) {
                return "redirect:/home";
            } else {
                throw new RuntimeException("Неверный пароль");
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

}
