package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.BookmarkRepository;
import com.example.demo.domain.EventRepository;
import com.example.demo.domain.GroupRepository;
import com.example.demo.domain.ImageRepository;
import com.example.demo.domain.PostRepository;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.domain.UserRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Hello Spring Boot");
	}

	@Autowired
	UserRepository UserRepository;
	@Autowired
	ImageRepository ImageRepository;
	@Autowired
	PostRepository PostRepository;
	@Autowired
	RestaurantRepository RestaurantRepository;
	@Autowired
	EventRepository EventRepository;

	@Autowired
	BookmarkRepository BookmarkRepository;

	@Autowired
	GroupRepository GroupRepository;
}
