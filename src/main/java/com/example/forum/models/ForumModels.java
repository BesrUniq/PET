//package com.example.forum.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//public class ForumModels {
//
//    @Entity
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class User {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        private String username;
//        private String password;
//        private String email;
//    }
//
//    @Entity
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class Post {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        private String title;
//        private String content;
//
//        @ManyToOne
//        private User user;
//    }
//}
