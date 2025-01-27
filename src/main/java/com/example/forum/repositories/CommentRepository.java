package com.example.forum.repositories;


import com.example.forum.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
   List<Comment> findByTopicId(Long topicId);
}
