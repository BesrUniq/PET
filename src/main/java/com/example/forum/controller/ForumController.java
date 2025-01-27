package com.example.forum.controller;

import com.example.forum.models.Topic;
import com.example.forum.models.Post;
import com.example.forum.models.User;
import com.example.forum.repositories.TopicRepository;
import com.example.forum.service.TopicService;
import com.example.forum.service.PostService;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ForumController {

    private final UserService userService;
    private final PostService postService;
    private final TopicService topicService;

    public ForumController(TopicService topicService, PostService postService, UserService userService) {
        this.userService = userService;
        this.topicService = topicService;
        this.postService = postService;
    }


    @GetMapping("/forum")
    public String home(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);

        for (Topic topic : topics) {
            List<Post> posts = postService.findPostsByTopicId(topic.getId());
            topic.setPosts(posts);
        }

        return "index";
    }


    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
        return "redirect:/";
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
        User user = userService.findById(userId);
        Topic topic = topicService.findById(topicId);

        if (user == null || topic == null) {
            return "redirect:/";
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setTopic(topic);
        postService.save(post);

        return "redirect:/forum";
    }

    @Autowired
    private TopicRepository topicRepository;
    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    @ModelAttribute("post")
    public List<Topic> getTopic() {
        return  (List<Topic>) topicRepository.findAll();
    }

}





