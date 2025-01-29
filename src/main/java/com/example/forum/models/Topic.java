package com.example.forum.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorName;
    private String topicSelection;
    private String topicMessage;


    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTopicSelection() {
        return topicSelection;
    }

    public void setTopicSelection(String topicSelection) {
        this.topicSelection = topicSelection;
    }

    public String getTopicMessage() {
        return topicMessage;
    }

    public void setTopicMessage(String topicMessage) {
        this.topicMessage = topicMessage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
