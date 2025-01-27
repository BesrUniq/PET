package com.example.forum.service;

import com.example.forum.models.Topic;
import com.example.forum.repositories.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }


    public Topic findByIdOrThrow(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic с ID " + id + " не найден!"));
    }
}


