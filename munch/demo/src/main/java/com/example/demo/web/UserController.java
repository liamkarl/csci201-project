package com.example.demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.security.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@GetMapping("/name")
	public String getName(@AuthenticationPrincipal UserDetailsImpl userDetails) {
		return userDetails.getUsername();
	}

	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return UserRepository.findAll();
	}

	@PostMapping("/name")
	public ResponseEntity<?> setName(@AuthenticationPrincipal UserDetailsImpl userDetails, String username) {
		Optional<User> optionalUser = UserRepository.findByUsername(userDetails.getUsername());
		User user = optionalUser.get();

		user.setUsername(username);
		UserRepository.save(user);
		return ResponseEntity.ok("Username updated successfully!");
	}

}
