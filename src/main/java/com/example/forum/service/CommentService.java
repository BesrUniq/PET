package com.example.forum.service;

import com.example.forum.models.Comment;
import com.example.forum.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findByTopicId(Long topicId) {
        return commentRepository.findByTopicId(topicId);
    }

    @Transactional
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}

