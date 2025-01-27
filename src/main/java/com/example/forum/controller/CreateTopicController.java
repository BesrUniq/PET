package com.example.forum.controller;

import com.example.forum.models.Post;
import com.example.forum.models.Topic;
import com.example.forum.repositories.TopicRepository;
import com.example.forum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Controller
public class CreateTopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Transactional
    @GetMapping("/create-topic")
    public String showCreateTopicForm() {
        return "create-topic";
    }

    @PostMapping("/create-topic")
    public String createTopic(@RequestParam String authorName,
                              @RequestParam String topicSelection,
                              @RequestParam String topicMessage) {
        try {
            Topic topic = new Topic();
            topic.setAuthorName(authorName);
            topic.setTopicSelection(topicSelection);
            topic.setTopicMessage(topicMessage);

            topicRepository.save(topic);

            System.out.println("Topic saved successfully!");
        } catch (Exception e) {

            System.err.println("Error saving topic: " + e.getMessage());
            return "create-topic";
        }


        return "redirect:/";
    }
}



