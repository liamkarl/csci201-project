package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "UserTable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column(nullable = false, updatable = false)
	private Long userID;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPosts, numFollowers, numFollowing;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Bookmark> bookmarks;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "groupID"))
	private Set<Group> groups;

	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String role;

	private String bio;
	private String pfp;

	public User() {
		super();
		this.numFollowers = 0;
		this.numPosts = 0;
		this.numFollowing = 0;

		this.posts = new ArrayList<Post>();
		this.bookmarks = new ArrayList<Bookmark>();
		this.groups = new HashSet<Group>(0);

		this.username = "";
		this.password = "";
		this.email = "";
		this.role = "user";
		this.bio = "";
		this.pfp = "";
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(int numPosts, int numFollowers, int numFollowing, List<Post> posts, List<Bookmark> bookmarks,
			Set<Group> groups, String username, String password, String email, String role, String bio, String pfp) {
		super();
		this.numPosts = numPosts;
		this.numFollowers = numFollowers;
		this.numFollowing = numFollowing;
		
		this.posts = posts;
		this.bookmarks = bookmarks;
		this.groups = groups;
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.bio = bio;
		this.pfp = pfp;
	}

	// getters/setters

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
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

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPfp() {
		return pfp;
	}

	public void setPfp(String pfp) {
		this.pfp = pfp;
	}
}