package com.example.demo.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.domain.PostRepository;
import com.example.demo.domain.Restaurant;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.payload.NewPostRequest;
import com.example.demo.security.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostRepository PostRepository;
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private RestaurantRepository RestaurantRepository;

	@DeleteMapping("/remove")
	public ResponseEntity<?> deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, Long PostID) {
		Optional<Post> optionalPost = PostRepository.findById(PostID);
		Post post = optionalPost.get();

		PostRepository.delete(post);
		return ResponseEntity.ok("Post removed successfully!");
	}

	@RequestMapping("/posts")
	public Iterable<Post> getPosts() {
		return PostRepository.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<?> newPost(@AuthenticationPrincipal UserDetailsImpl userDetails,
			@Valid @RequestBody NewPostRequest PostRequest) {
		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User user = optionalUser.get();

		// Just gets the first restaurant by inputted name from database
		Restaurant restaurant = RestaurantRepository.findByName(PostRequest.getRestaurantName()).get(0);

		// Create new post
		Post post = new Post(user, restaurant);
		post.setRating(PostRequest.getRating());
		post.setPostText(PostRequest.getPostText());
		post.setLocation(PostRequest.getLocation());

		// Upload post to database
		post = PostRepository.save(post);

		// Updating user and restaurant with new post info
		user.addPost(post);
		restaurant.addPost(post);
		UserRepository.save(user);
		RestaurantRepository.save(restaurant);

		return ResponseEntity.ok("Post uploaded successfully!");
	}

}
