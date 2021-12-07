package com.example.demo.payload;

import java.net.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class NewPostRequest {
	@NotBlank
	private String restaurantName;
	@NotNull(message = "rating may not be empty")
	@Range(min = 1, max = 5)
	private int rating;
	@NotBlank
	private String postText;
	@NotBlank
	private String location;
	private URL image;

	public URL getImage() {
		return image;
	}

	public String getLocation() {
		return location;
	}

	public String getPostText() {
		return postText;
	}

	public int getRating() {
		return rating;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setImage(URL image) {
		this.image = image;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
