package com.example.forum.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String profilePage(Authentication authentication, Model model) {

        String username = authentication.getName();


        model.addAttribute("username", username);

        return "profile";
    }
}

