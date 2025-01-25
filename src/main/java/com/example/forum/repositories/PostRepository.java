package com.example.forum.repositories;

import com.example.forum.models.Post;
import com.example.forum.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

    List<Post> findByTopicId(Long topicId);
}

