package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "UserTable")
public class User {
	// done
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPosts, numFollowers, numFollowing;

	private String bio;
	private String pfp;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Post> posts;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long userID;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String role;

	public User() {

	}

	public User(String username, String password, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	// getters/setters
	public long getUserID() {
		return userID;
	}

	public void setUserID(long id) {
		userID = id;
	}

	public int getNumPosts() {
		return numPosts;
	}

	public void setNumPosts(int numPosts) {
		this.numPosts = numPosts;
	}

	public int getNumFollowers() {
		return numFollowers;
	}

	public void setNumFollowers(int numFollowers) {
		this.numFollowers = numFollowers;
	}

	public int getNumFollowing() {
		return numFollowing;
	}

	public void setNumFollowing(int numFollowing) {
		this.numFollowing = numFollowing;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProfilePic() {
		return pfp;
	}

	public void setProfilePic(String url) {
		this.pfp = url;
	}
	// class specific

	// TODO: newPost(Post p)
	// List<Group> getGroups()
	// void addGroup(Group g)
	// void removeGroup(Group g)

	public boolean Register(String username, String password, String email) {
		boolean validityCheck = true;

		// if username or email is in use already, fails
		if (!validityCheck)
			return false;

		else {
			this.username = username;
			this.password = password;
			this.email = email;

			return true;
		}
	}

	public boolean Login(String identifier, String password) {
		return (((identifier == this.email) || (identifier == this.username)) && (password == this.password));
	}

	public boolean newPost(Post p) {
		this.numPosts++;

		return true;
	}

	public boolean verifyPassword(String attempt) {
		if (attempt.equals(password))
			return true;
		return false;
	}

	public void changePassword(String newPwd) {
		password = newPwd;
	}

}
