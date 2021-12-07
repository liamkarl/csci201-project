package com.example.demo.payload;

import javax.validation.constraints.NotBlank;

public class RestaurantRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String cuisine;
	@NotBlank
	private String price;
	@NotBlank
	private String location;
	private String menuLink;

	public String getCuisine() {
		return cuisine;
	}

	public String getLocation() {
		return location;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
