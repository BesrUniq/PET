//package com.example.forum.services;
//
//import com.example.forum.models.User;
//import com.example.forum.models.Post;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    public User findById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//}
//
//@Service
//public class PostService {
//    private final PostRepository postRepository;
//
//    public PostService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    public List<Post> findAll() {
//        return postRepository.findAll();
//    }
//
//    public List<Post> findByUser(User user) {
//        return postRepository.findByUser(user);
//    }
//
//    public Post save(Post post) {
//        return postRepository.save(post);
//    }
//
//    public Post findById(Long id) {
//        return postRepository.findById(id).orElse(null);
//    }
//}
