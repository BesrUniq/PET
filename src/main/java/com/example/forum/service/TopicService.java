package com.example.forum.service;

import com.example.forum.models.Topic;
import com.example.forum.repositories.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }
}

