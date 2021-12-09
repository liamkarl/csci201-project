package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.domain.Restaurant;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.security.service.UserDetailsImpl;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ListPageController {
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private RestaurantRepository RestaurantRepository;

	/*
	@GetMapping("/view")
	public ResponseEntity<Object> getList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
		if (userDetails == null) {
			return ResponseEntity.badRequest()
					.body(new Message("Error: You must be logged in to view saved Restaurants!"));
		}

		User user = UserRepository.findByUsername(userDetails.getUsername()).get();
		List<JSONObject> restaurantJSONList = new ArrayList<>();

		final int pageMax = 20;
		int restaurantCount = 0;

		for (Restaurant restaurant : user.getRestaurantList()) {
			JSONObject restaurantJSON = new JSONObject();

			restaurantJSON.put("category", restaurant.getCuisine());
			restaurantJSON.put("image",
					restaurant.getImages().get(new Random().nextInt((restaurant.getImages().size()))));

			JSONObject content = new JSONObject();

			restaurantJSON.put("content", content);
			content.put("image", restaurant.getImages().get(new Random().nextInt((restaurant.getImages().size()))));
			content.put("restaurant", restaurantJSONList);

			restaurantJSONList.add(restaurantJSON);
			restaurantCount++;

			if (restaurantCount >= pageMax)
				break;
		}

		return new ResponseEntity<>(restaurantJSONList, HttpStatus.OK);
	}
	*/
}
