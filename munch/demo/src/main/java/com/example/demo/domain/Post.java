package com.example.demo.domain;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@ElementCollection
	private List<String> comments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	@JsonIgnore
	private Restaurant restaurant;

	@Column(nullable = false, updatable = false)
	@Range(min = 1, max = 5)
	private Integer rating;

	@Column(nullable = false, updatable = true)
	@Range(min = 0)
	private Integer likes;

	private String postText, location;

	private LocalDateTime date;

	private URL image;

	public Post() {
		super();

		this.date = LocalDateTime.now();
	}

	public Post(URL image, User user, Restaurant restaurant, Integer rating, String postText, String location) {
		super();
		this.image = image;
		this.comments = new ArrayList<>();
		this.user = user;
		this.restaurant = restaurant;
		this.rating = rating;
		this.likes = 0;
		this.postText = postText;
		this.location = location;

		this.date = LocalDateTime.now();
	}

	public List<String> getComments() {
		return comments;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public URL getImage() {
		return image;
	}

	public Integer getLikes() {
		return likes;
	}

	public String getLocation() {
		return location;
	}

	public Long getPostID() {
		return postID;
	}

	public String getPostText() {
		return postText;
	}

	public Integer getRating() {
		return rating;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setImage(URL image) {
		this.image = image;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPostID(Long postID) {
		this.postID = postID;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setUser(User user) {
		this.user = user;
	}
}