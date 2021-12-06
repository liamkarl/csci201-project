package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookmarkTable")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long bookmarkID;

	private String noteText;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	private Restaurant restaurant;

	public Bookmark() {
		super();

		this.noteText = "";
		this.user = new User();
		this.restaurant = new Restaurant();
	}

	public Bookmark(String noteText, User user, Restaurant restaurant) {
		super();
		this.noteText = noteText;
		this.user = user;
		this.restaurant = restaurant;
	}

	// getters/setters

	public long getBookmarkID() {
		return bookmarkID;
	}

	public void setBookmarkID(long bookmarkID) {
		this.bookmarkID = bookmarkID;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
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
}