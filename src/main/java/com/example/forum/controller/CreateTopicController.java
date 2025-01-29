package com.example.forum.controller;


import com.example.forum.models.Category;
import com.example.forum.service.CategoryService;
import com.example.forum.models.Topic;
import com.example.forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Controller
public class CreateTopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CategoryService categoryService;


    @Transactional
    @GetMapping("/create-topic")
    public String showCreateTopicForm(Model model) {
        List<Category> categories = categoryService.findAll();

        model.addAttribute("categories", categories);

        return "create-topic";
    }


    @PostMapping("/create-topic")
    public String createTopic(@RequestParam String authorName,
                              @RequestParam String topicMessage,
                              @RequestParam Long categoryId) {
        try {
            Category category = categoryService.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Категория не найдена"));

            Topic topic = new Topic();
            topic.setAuthorName(authorName);
            topic.setTopicMessage(topicMessage);
            topic.setCategory(category);

            topicRepository.save(topic);

            System.out.println("Topic saved successfully!");
        } catch (Exception e) {

            System.err.println("Error saving topic: " + e.getMessage());
            return "create-topic";
        }


        return "redirect:/";
    }
}



