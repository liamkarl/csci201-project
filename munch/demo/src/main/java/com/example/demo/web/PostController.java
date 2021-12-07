package com.example.demo.web;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.demo.payload.RemovePostRequest;
import com.example.demo.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
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
	public ResponseEntity<?> deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails,
			@Valid @RequestBody RemovePostRequest PostRequest) {
		Optional<Post> optionalPost = PostRepository.findById(PostRequest.getPostID());
		Post post = optionalPost.get();
		User user = post.getUser();
		Restaurant restaurant = post.getRestaurant();

		// Remove post from User and Restaurant profiles
		user.removePost(post);
		restaurant.removePost(post);

		// Update database
		UserRepository.save(user);
		RestaurantRepository.save(restaurant);
		PostRepository.delete(post);

		return ResponseEntity.ok("Post removed successfully!");
	}

	@RequestMapping("/posts")
	public Iterable<Post> getPosts() {
		return PostRepository.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<?> newPost(@AuthenticationPrincipal @NotNull UserDetailsImpl userDetails,
			@Valid @RequestBody NewPostRequest PostRequest) {
		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User user = optionalUser.get();

		Restaurant restaurant;

		// Finds the first restaurant of that name in database if it exists
		if (RestaurantRepository.existsByName(PostRequest.getLocation())) {
			restaurant = RestaurantRepository.findByName(PostRequest.getLocation()).get(0);
		}

		// Else, adds the restaurant to the database
		else {
			restaurant = new Restaurant(PostRequest.getLocation());

			restaurant = RestaurantRepository.save(restaurant);
		}

		// Create new post
		Post post = new Post(PostRequest.getImage(), user, restaurant, PostRequest.getRating(),
				PostRequest.getPostText(), PostRequest.getLocation());

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
