package com.example.forum.service;

import com.example.forum.models.Post;
import com.example.forum.models.User;
import com.example.forum.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> findAll() {
        return postRepository.findAll();
    }


    public List<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }


    public List<Post> findPostsByTopicId(Long topicId) {
        return postRepository.findByTopicId(topicId);
    }


    public Post save(Post post) {
        return postRepository.save(post);
    }


    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}


