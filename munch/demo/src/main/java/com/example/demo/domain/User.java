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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "UserTable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false, unique = true)
	private Long userID = Long.valueOf(0);

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPosts, numFollowers, numFollowing;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	@JsonIgnore
	private List<Post> posts;

	@OneToMany(mappedBy = "userFollower")
	private Set<Follower> following;

	@OneToMany(mappedBy = "userFollowing")
	private Set<Follower> followers;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "groupID"))
	private Set<Group> groups;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "liked_posts", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "postID"))
	private Set<Post> likedPosts;

	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;

	private String email;
	private String bio;
	private String pfp;

	public User() {
		super();
		this.numFollowers = 0;
		this.numFollowing = 0;
		this.numPosts = 0;

		this.followers = new HashSet<>();
		this.following = new HashSet<>();

		this.posts = new ArrayList<>();
		this.groups = new HashSet<>();
		this.likedPosts = new HashSet<>();

		this.username = "";
		this.password = "";
		this.email = "";
		this.role = "USER";
		this.bio = "";
		this.pfp = "";
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.email = "";
		this.role = "USER";

		this.followers = new HashSet<>();
		this.following = new HashSet<>();

		this.posts = new ArrayList<>();
		this.groups = new HashSet<>();
		this.likedPosts = new HashSet<>();

		this.numFollowers = 0;
		this.numFollowing = 0;
		this.numPosts = 0;
	}

	public User(String username, String password, String email, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;

		this.followers = new HashSet<>();
		this.following = new HashSet<>();

		this.posts = new ArrayList<>();
		this.groups = new HashSet<>();
		this.likedPosts = new HashSet<>();

		this.numFollowers = 0;
		this.numFollowing = 0;
		this.numPosts = 0;
	}

	public void addFollower(Follower follower) {
		this.followers.add(follower);
		this.numFollowers++;
	}

	public void addFollowing(Follower following) {
		this.following.add(following);
		this.numFollowing++;
	}

	public void addLikedPost(Post post) {
		this.likedPosts.add(post);
		post.setLikes(post.getLikes() + 1);
	}

	public void addPost(Post post) {
		this.posts.add(post);
		this.numPosts++;
	}

	public String getBio() {
		return bio;
	}

	public String getEmail() {
		return email;
	}

	public Set<Follower> getFollowers() {
		return followers;
	}

	public Set<Follower> getFollowing() {
		return following;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public Set<Post> getLikedPosts() {
		return likedPosts;
	}

	public int getNumFollowers() {
		return numFollowers;
	}

	public int getNumFollowing() {
		return numFollowing;
	}

	public int getNumPosts() {
		return numPosts;
	}

	public String getPassword() {
		return password;
	}

	public String getPfp() {
		return pfp;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public String getRole() {
		return role;
	}

	public Long getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public void removeFollower(Follower follower) {
		this.followers.remove(follower);
		this.numFollowers--;
	}

	public void removeFollowing(Follower following) {
		this.following.remove(following);
		this.numFollowing--;
	}

	public void removeLikedPost(Post post) {
		this.likedPosts.remove(post);
		post.setLikes(post.getLikes() - 1);
	}

	public void removePost(Post post) {
		this.posts.remove(post);
		this.numPosts--;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFollowers(Set<Follower> followers) {
		this.followers = followers;
	}

	public void setFollowing(Set<Follower> following) {
		this.following = following;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public void setLikedPosts(Set<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}

	public void setNumFollowers(int numFollowers) {
		this.numFollowers = numFollowers;
	}

	public void setNumFollowing(int numFollowing) {
		this.numFollowing = numFollowing;
	}

	public void setNumPosts(int numPosts) {
		this.numPosts = numPosts;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPfp(String pfp) {
		this.pfp = pfp;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}