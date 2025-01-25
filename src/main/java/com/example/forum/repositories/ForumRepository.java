//package com.example.forum.repositories;
//
//
//import org.apache.catalina.User;
//import com.example.forum.models.Post;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//public class ForumRepository {
//
//    @Repository
//    public interface UserRepository extends JpaRepository<User, Long> {
//        Optional<User> findByUsername(String username);
//    }
//
//    @Repository
//    public interface PostRepository extends JpaRepository<Post, Long> {
//        List<Post> findByUser(User user);
//    }
//
//}
