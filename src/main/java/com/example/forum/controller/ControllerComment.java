package com.example.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.forum.models.Comment;
import com.example.forum.models.Topic;
import com.example.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import com.example.forum.service.CommentService;





import java.util.List;


@Controller
public class ControllerComment {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/topic/{id}")
    public String getDiscussionPage(@PathVariable Long id, Model model) {

        Topic topic = topicService.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));


        List<Comment> comments = commentService.findByTopicId(id );


        model.addAttribute("topic", topic);
        model.addAttribute("comments", comments);



        return "discussion";
    }

    @PostMapping("/submit-comment")
    public String submitComment(@RequestParam Long topicId,
                                @RequestParam String text,
                                Principal principal) {

        if (principal == null) {
            throw new RuntimeException("Ошибка: пользователь не аутентифицирован");
        }

        String username = principal.getName();

        Topic topic = topicService.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic с ID " + topicId + " не найден"));

        Comment comment = new Comment();
        comment.setTopic(topic);
        comment.setUsername(username);
        comment.setText(text);
        comment.setTimePosted(LocalDateTime.now());

        commentService.save(comment);

        return "redirect:/topic/" + topicId;
    }




}
