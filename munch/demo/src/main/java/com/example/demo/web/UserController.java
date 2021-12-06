package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository repo;

	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return repo.findAll();
	}
}
