package com.example.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerJS {


    @GetMapping("/forum")
    public String home() {
        return "index";
    }


    @GetMapping("/posts")
    public String posts() {
        return "posts";
    }




    @GetMapping("/discussion")
    public String discussion() {
        return "discussion";
    }


    @GetMapping("/custom-login")
    public String login() {
        return "customlogin";
    }


}

