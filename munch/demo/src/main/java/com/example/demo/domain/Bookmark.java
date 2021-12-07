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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BookmarkTable")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false)
	private Long bookmarkID = Long.valueOf(0);

	private String noteText;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	private Restaurant restaurant;

	public Bookmark() {
		super();
	}

	public Bookmark(String noteText, User user, Restaurant restaurant) {
		super();
		this.noteText = noteText;
		this.user = user;
		this.restaurant = restaurant;
	}

	public Bookmark(User user, Restaurant restaurant) {
		super();

		this.noteText = "";
		this.user = user;
		this.restaurant = restaurant;
	}

	// getters/setters

	public long getBookmarkID() {
		return bookmarkID;
	}

	public String getNoteText() {
		return noteText;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setBookmarkID(Long bookmarkID) {
		this.bookmarkID = bookmarkID;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setUser(User user) {
		this.user = user;
	}
}