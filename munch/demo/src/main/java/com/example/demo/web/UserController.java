package com.example.demo.web;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Follower;
import com.example.demo.domain.FollowerRepository;
import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private FollowerRepository FollowerRepository;

	@PostMapping("/follow")
	public ResponseEntity<?> addFollower(@AuthenticationPrincipal @NotNull UserDetailsImpl userDetails,
			@RequestParam @NotBlank String username) {
		if (userDetails == null)
			return ResponseEntity.badRequest().body(new Message("Error: You must be logged in to follow accounts!"));

		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User userFollower = optionalUser.get();

		User userFollowing;

		// Finds the other user of that name in database if it exists
		if ((UserRepository.existsByUsername(username)) && !(username.equals(userFollower.getUsername()))) {
			optionalUser = UserRepository.findByUsername(username);
			userFollowing = optionalUser.get();

			if (FollowerRepository.existsByUserFollowerAndUserFollowing(userFollower, userFollowing))
				return ResponseEntity.badRequest().body(new Message("Error: You already follow this account!"));
		}

		// If someone tries to follow oneself, return error
		else if (username.equals(userFollower.getUsername())) {
			return ResponseEntity.badRequest().body(new Message("Error: You cannot follow your own account!"));
		}

		// If user doesn't exist, return error
		else {
			return ResponseEntity.badRequest().body(new Message("Error: That user doesn't exist!"));
		}

		Follower newRelation = new Follower(userFollower, userFollowing);

		FollowerRepository.save(newRelation);

		userFollower.addFollowing(newRelation);
		userFollowing.addFollower(newRelation);

		UserRepository.save(userFollower);
		UserRepository.save(userFollowing);

		return ResponseEntity.ok("Followed user successfully!");
	}

	@GetMapping("/name")
	public String getName(@AuthenticationPrincipal UserDetailsImpl userDetails) {
		return userDetails.getUsername();
	}

	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return UserRepository.findAll();
	}

	@DeleteMapping("/unfollow")
	public ResponseEntity<?> removeFollower(@AuthenticationPrincipal @NotNull UserDetailsImpl userDetails,
			@RequestParam @NotBlank String username) {
		if (userDetails == null)
			return ResponseEntity.badRequest().body(new Message("Error: You must be logged in to unfollow accounts!"));

		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User userFollower = optionalUser.get();

		User userFollowing;

		// Finds the other user of that name in database if it exists
		if ((UserRepository.existsByUsername(username)) && !(username.equals(userFollower.getUsername()))) {
			optionalUser = UserRepository.findByUsername(username);
			userFollowing = optionalUser.get();

			if (!FollowerRepository.existsByUserFollowerAndUserFollowing(userFollower, userFollowing))
				return ResponseEntity.badRequest().body(new Message("Error: You don't follow this account!"));
		}

		// If someone tries to unfollow oneself, return error
		else if (username.equals(userFollower.getUsername())) {
			return ResponseEntity.badRequest().body(new Message("Error: You cannot unfollow your own account!"));
		}

		// If user doesn't exist, return error
		else {
			return ResponseEntity.badRequest().body(new Message("Error: That user doesn't exist!"));
		}

		Optional<Follower> optionalFollower = FollowerRepository.findByUserFollowerAndUserFollowing(userFollower,
				userFollowing);
		Follower delRelation = optionalFollower.get();

		FollowerRepository.delete(delRelation);

		userFollower.removeFollowing(delRelation);
		userFollowing.removeFollower(delRelation);

		UserRepository.save(userFollower);
		UserRepository.save(userFollowing);

		return ResponseEntity.ok("Unfollowed user successfully!");
	}

	@PostMapping("/name")
	public ResponseEntity<?> setName(@AuthenticationPrincipal UserDetailsImpl userDetails, String username) {
		if (userDetails == null)
			return ResponseEntity.badRequest().body(new Message("Error: You must be logged in to change a username!"));

		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User user = optionalUser.get();

		user.setUsername(username);
		UserRepository.save(user);
		return ResponseEntity.ok("Username updated successfully!");
	}

}
