package com.example.forum;

import com.example.forum.service.PostService;
import com.example.forum.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class ForumApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@Test
	void contextLoads() {
		assertNotNull(userService);
		assertNotNull(postService);
	}

	

}
