package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RestaurantTable")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long restaurantID;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Post> posts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Bookmark> bookmarks;

	private String name, cuisine, price, location, menuLink;
	private Double avgRating;

	public Restaurant() {
		super();

		this.posts = new ArrayList<Post>();
		this.bookmarks = new ArrayList<Bookmark>();

		this.name = "";
		this.cuisine = "";
		this.price = "";
		this.location = "";
		this.menuLink = "";

		this.avgRating = 0.0;
	}

	public Restaurant(List<Post> posts, List<Bookmark> bookmarks, String name, String cuisine, String price,
			String location, String menuLink, Double avgRating) {
		super();

		this.posts = posts;
		this.bookmarks = bookmarks;

		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.location = location;
		this.menuLink = menuLink;

		this.avgRating = avgRating;
	}

	// getters/setters

	public long getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(long restaurantID) {
		this.restaurantID = restaurantID;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	// private List<Image> images
	// private Map<Integer, Post> popularPosts
	// private Map<Integer, Post> criticalPosts

}
