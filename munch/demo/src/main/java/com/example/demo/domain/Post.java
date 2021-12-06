package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

//import java.time.LocalDateTime;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "PostTable")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false)
	private Long postID = Long.valueOf(0);

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

	@ElementCollection
	private List<String> comments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	private Restaurant restaurant;

	private int rating, likes;
	private String postText, location;
	private LocalDateTime date;

	public Post() {
		super();
	}

	public Post(User user, Restaurant restaurant) {
		super();

		this.images = new ArrayList<Image>();
		this.comments = new ArrayList<String>();
		this.user = user;
		this.restaurant = restaurant;

		this.rating = 0;
		this.likes = 0;

		this.postText = "";
		this.location = "";

		this.date = LocalDateTime.now();
	}

	public Post(List<Image> images, List<String> comments, User user, Restaurant restaurant, int rating, int likes,
			String postText, String location) {
		super();
		this.images = images;
		this.comments = comments;
		this.user = user;
		this.restaurant = restaurant;
		this.rating = rating;
		this.likes = likes;
		this.postText = postText;
		this.location = location;

		this.date = LocalDateTime.now();
	}

	// getters/setters

	public Long getPostID() {
		return postID;
	}

	public void setPostID(Long postID) {
		this.postID = postID;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}