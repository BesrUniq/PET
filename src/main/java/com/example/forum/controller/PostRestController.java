package com.example.forum.controller;

import com.example.forum.models.Post;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }
}
