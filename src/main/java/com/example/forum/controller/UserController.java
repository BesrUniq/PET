//package com.example.forum.controller;
//
//import com.example.forum.models.User;
//import com.example.forum.service.UserService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/profile")
//    public String profilePage(Model model, @AuthenticationPrincipal Authentication authentication) {
//        System.out.println("Метод profilePage вызван!");
//
//        if (authentication == null) {
//            System.out.println("Ошибка: authentication == null (пользователь не аутентифицирован)");
//            return "redirect:/login";
//        }
//
//        System.out.println("authentication: " + authentication);
//
//        String username = authentication.getName();
//        System.out.println("Текущий пользователь: " + username);
//
//        User user = userService.findByUsername(username);
//        if (user == null) {
//            System.out.println("Ошибка: пользователь не найден в БД!");
//            return "redirect:/login?error=Пользователь не найден";
//        }
//
//        System.out.println("Загружен пользователь: " + user.getUsername());
//        System.out.println("Фото профиля: " + user.getProfilePicture());
//
//        model.addAttribute("user", user);
//
//        return "profile";
//    }
//}

