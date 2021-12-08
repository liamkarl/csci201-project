package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Bookmark;
import com.example.demo.domain.BookmarkRepository;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.domain.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bookmark")
public class BookmarkController {
	@Autowired
	private BookmarkRepository BookmarkRepository;
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private RestaurantRepository RestaurantRepository;

	@RequestMapping("bookmarks")
	public Iterable<Bookmark> getBookmarks() {
		return BookmarkRepository.findAll();
	}
}
