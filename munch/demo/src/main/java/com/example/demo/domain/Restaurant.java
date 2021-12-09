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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RestaurantTable")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false, unique = true)
	private Long restaurantID = Long.valueOf(0);

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Post> posts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	@JsonIgnore
	private List<Event> events;

	@Column(nullable = false)
	private String name, cuisine, price, address;

	private String menuLink;
	private Double avgRating;

	public Restaurant() {
		super();

		this.posts = new ArrayList<>();
		this.events = new ArrayList<>();

		this.name = "";
		this.cuisine = "";
		this.price = "";
		this.address = "";
		this.menuLink = "";

		this.avgRating = 0.0;
	}

	public Restaurant(String name) {
		super();

		this.posts = new ArrayList<>();
		this.events = new ArrayList<>();

		this.name = name;
		this.cuisine = "";
		this.price = "";
		this.address = "";
		this.menuLink = "";

		this.avgRating = 0.0;
	}

	public Restaurant(String name, String cuisine, String price, String address) {
		super();

		this.posts = new ArrayList<>();
		this.events = new ArrayList<>();

		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.address = address;
		this.menuLink = "";

		this.avgRating = 0.0;
	}

	public Restaurant(String name, String cuisine, String price, String address, String menuLink) {
		super();

		this.posts = new ArrayList<>();
		this.events = new ArrayList<>();

		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.address = address;
		this.menuLink = menuLink;

		this.avgRating = 0.0;
	}

	public void addEvent(Event event) {
		this.events.add(event);
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

	public void removeEvent(Event event) {
		this.events.remove(event);
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
}