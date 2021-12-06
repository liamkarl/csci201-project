package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.BookmarkController;
import com.example.demo.web.EventController;
import com.example.demo.web.GroupController;
import com.example.demo.web.ImageController;
import com.example.demo.web.PostController;
import com.example.demo.web.RestaurantController;
import com.example.demo.web.UserController;

// Testing the major functionality of our application before we create any formal test cases.
// The following test checks that the instances of the controller classes were created/injected successfully.

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserController userController;

	@Autowired
	private RestaurantController restaurantController;

	@Autowired
	private BookmarkController bookmarkController;

	@Autowired
	private EventController eventController;

	@Autowired
	private ImageController imageController;

	@Autowired
	private PostController postController;

	@Autowired
	private GroupController groupController;

	@Test
	public void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(restaurantController).isNotNull();
		assertThat(bookmarkController).isNotNull();
		assertThat(eventController).isNotNull();
		assertThat(imageController).isNotNull();
		assertThat(postController).isNotNull();
		assertThat(groupController).isNotNull();
	}

}
