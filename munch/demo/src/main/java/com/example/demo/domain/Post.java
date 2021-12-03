package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

//import java.time.LocalDateTime;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PostTable")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postID;

	private long userID, restaurantID;
	private int rating, likes;

	private String postText, location;
	private List<Image> images;
	private List<String> comments;

	private LocalDateTime date;

	public Post() {

	}

	public Post(long userID, long restaurantID, int rating) {
		this.userID = userID;
		this.restaurantID = restaurantID;
		this.rating = rating;
		date = LocalDateTime.now();
	}

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getPostID() {
		return postID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getUserID() {
		return userID;
	}

	public void setRestaurantID(long restaurantID) {
		this.restaurantID = restaurantID;
	}

	public long getRestaurantID() {
		return restaurantID;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getLikes() {
		return likes;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostText() {
		return postText;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getDate() {
		return date;
	}
}
