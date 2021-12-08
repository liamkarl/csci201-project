package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.domain.PostRepository;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/explore")
public class ExplorePageController {
	@Autowired
	private PostRepository PostRepository;

	@GetMapping("/posts")
	public ResponseEntity<Object> getPosts() {
		List<JSONObject> postJSONList = new ArrayList<>();
		final int pageMax = 20;
		int postCount = 0;

		for (Post post : PostRepository.findAllByOrderByLikesDesc()) {
			JSONObject postJSON = new JSONObject();

			postJSON.put("post", post);
			postJSON.put("user", post.getUser().getUserID());
			postJSON.put("restaurant", post.getRestaurant().getRestaurantID());

			postJSONList.add(postJSON);
			postCount++;

			if (postCount >= pageMax)
				break;
		}

		return new ResponseEntity<>(postJSONList, HttpStatus.OK);
	}
}
