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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RestaurantTable")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false)
	private Long restaurantID = Long.valueOf(0);

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Post> posts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
	private List<Bookmark> bookmarks;

	@Column(nullable = false)
	private String name, cuisine, price, address;

	private String menuLink;
	private Double avgRating;

	public Restaurant() {
		super();

		this.posts = new ArrayList<>();
		this.bookmarks = new ArrayList<>();

		this.name = "";
		this.cuisine = "";
		this.price = "";
		this.address = "";
		this.menuLink = "";

		this.avgRating = 0.0;
	}
	public Restaurant(String name) {
		super();

<<<<<<< HEAD
=======
	public Restaurant(String name) {
		super();

		this.posts = new ArrayList<>();
		this.bookmarks = new ArrayList<>();
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6

		this.name = name;
		this.cuisine = "";
		this.price = "";
<<<<<<< HEAD
=======
		this.address = "";
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6
		this.menuLink = "";

		this.avgRating = 0.0;
	}
<<<<<<< HEAD
	public Restaurant(String name, String cuisine, String price, String location) {
		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.location = location;
		menuLink = "";
		avgRating = 0.0;
=======

	public Restaurant(String name, String cuisine, String price, String address, String menuLink) {
		super();

		this.posts = new ArrayList<>();
		this.bookmarks = new ArrayList<>();

		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.address = address;
		this.menuLink = menuLink;

		this.avgRating = 0.0;
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6
	}

	public void addPost(Post post) {
		this.posts.add(post);
		this.updateRating();
	}

	public String getAddress() {
		return address;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public String getCuisine() {
		return cuisine;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public String getName() {
		return name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public String getPrice() {
		return price;
	}

	public long getRestaurantID() {
		return restaurantID;
	}

	public void removePost(Post post) {
		this.posts.remove(post);

		this.updateRating();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setRestaurantID(Long restaurantID) {
		this.restaurantID = restaurantID;
	}

	// Update average rating from new post
	public void updateRating() {

		double sum = 0;
		int numPosts = this.posts.size();
		for (Post p : this.posts) {
			sum += p.getRating();
		}

		if (numPosts > 0)
			this.avgRating = sum / numPosts;

		else
			this.avgRating = 0.0;
	}

	// private List<Image> images
	// private Map<Integer, Post> popularPosts
	// private Map<Integer, Post> criticalPosts

}