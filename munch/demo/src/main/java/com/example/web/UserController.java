package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository repo;

	@RequestMapping("/users")
	public Iterable<User> getUsers() {
		return repo.findAll();
	}
}