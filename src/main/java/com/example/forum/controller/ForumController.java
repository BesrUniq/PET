package com.example.forum.controller;

import com.example.forum.models.*;
import com.example.forum.repositories.TopicRepository;
import com.example.forum.service.TopicService;
import com.example.forum.service.PostService;
import com.example.forum.service.UserService;
import com.example.forum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class ForumController {

    private final UserService userService;
    private final PostService postService;
    private final TopicService topicService;
    private final CategoryService categoryService;

    public ForumController(TopicService topicService, PostService postService, UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.topicService = topicService;
        this.postService = postService;
        this.categoryService = categoryService;
    }



    @GetMapping("/")
    public String home(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Topic> topics = topicService.findAll();

        for (Topic topic : topics) {
            List<Post> posts = postService.findPostsByTopicId(topic.getId());
            topic.setPosts(posts);
        }

        model.addAttribute("topics", topics);
        model.addAttribute("categories", categories);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", auth.getName());
        } else {
            model.addAttribute("isAuthenticated", false);
        }



        return "index";
    }

    @GetMapping("/topic/{id}/discussion")
    public String getDiscussionPage(@PathVariable Long id, Model model) {

        Topic topic = topicService.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        List<Post> posts = Optional.ofNullable(topic.getPosts()).orElse(Collections.emptyList());


        model.addAttribute("topic", topic);
        model.addAttribute("posts", posts);


        return "discussion";
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/post")
    public String createPost(@RequestParam String title, @RequestParam String content, @RequestParam Long userId, @RequestParam Long topicId) {
        User user = userService.findById(userId).orElse(new User());
        Topic topic = topicService.findById(topicId).orElse(null);

        if (user == null || topic == null) {
            return "redirect:/";
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setTopic(topic);
        postService.save(post);

        return "redirect:/";
    }

    @Autowired
    private TopicRepository topicRepository;
    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    @ModelAttribute("post")
    public List<Topic> getTopic() {
        return  (List<Topic>) topicRepository.findAll();
    }

}





