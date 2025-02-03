package com.example.forum.controller;

import com.example.forum.models.User;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.UUID;

@Controller
public class ProfileController {

    @Value("${upload.path}")
    private String uploadPath;

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profilePage(Model model,Authentication authentication) {
        System.out.println("Метод profilePage вызван!");

        if (authentication == null) {
            System.out.println("Ошибка: authentication == null (пользователь не аутентифицирован)");
            return "redirect:/login";
        }

        System.out.println("authentication: " + authentication);

        String username = authentication.getName();
        User user = userService.findByUsername(username);

        System.out.println("Загружен пользователь: " + user.getUsername());
        System.out.println("Фото профиля: " + user.getProfilePicture());

        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping("/profile/upload")
    public String uploadProfilePicture(@RequestParam("file") MultipartFile file, Model model
                                       ) {

        String uploadPath = "D:/PET/uploads";


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login?error=Пользователь не авторизован";
        }

        String username = authentication.getName();

        if (file.isEmpty()) {
            try {
                String errorMessage = "Файл не выбран";
                String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
                return "redirect:/profile?error=" + encodedMessage;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "redirect:/profile?error=Ошибка кодирования";
            }
        }

        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            File destFile = new File(uploadDir, filename);
            file.transferTo(destFile);

            User user = userService.findByUsername(username);
            user.setProfilePicture(filename);
            userService.save(user);

            model.addAttribute("user", user);

        } catch (IOException e) {
            e.printStackTrace();
            try {
                String errorMessage = "Ошибка загрузки файла";
                String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
                return "redirect:/profile?error=" + encodedMessage;
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                return "redirect:/profile?error=Ошибка кодирования";
            }
        }

        try {
            String successMessage = "Фото обновлено";
            String encodedMessage = URLEncoder.encode(successMessage, "UTF-8");
            return "redirect:/profile?success=" + encodedMessage;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "redirect:/profile?success=Ошибка кодирования";
        }
    }
}
