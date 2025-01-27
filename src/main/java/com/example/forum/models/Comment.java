package com.example.forum.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String text;

    private LocalDateTime timePosted;


    public Comment() {
    }

    public Comment(Topic topic, String username, String text, LocalDateTime timePosted) {
        this.topic = topic;
        this.username = username;
        this.text = text;
        this.timePosted = timePosted;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(LocalDateTime timePosted) {
        this.timePosted = timePosted;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", topic=" + (topic != null ? topic.getId() : "null") +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", timePosted=" + timePosted +
                '}';
    }
}

