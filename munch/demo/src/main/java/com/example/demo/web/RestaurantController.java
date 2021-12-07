package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.domain.Restaurant;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.payload.RestaurantRequest;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantRepository RestaurantRepository;

	@RequestMapping("/restaurants")
	public Iterable<Restaurant> getRestaurants() {
		return RestaurantRepository.findAll();
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RestaurantRequest restaurantRequest) {
		// Create new restaurant
		Restaurant restaurant = new Restaurant(restaurantRequest.getName(), restaurantRequest.getCuisine(),
				restaurantRequest.getPrice(), restaurantRequest.getLocation(), restaurantRequest.getMenuLink());

		RestaurantRepository.save(restaurant);

		return ResponseEntity.ok(new Message("Restaurant registered successfully!"));
	}
}