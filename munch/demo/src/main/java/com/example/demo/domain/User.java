package com.example.demo.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table( name = "UserTable")
public class User {
	//done
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userID;
	private int numPosts, numFollowers, numFollowing;
	
	private String username, password;
	private String bio;
	
	public User(String username, String password) {
		numPosts = 0; 
		numFollowers = 0;
		numFollowing = 0;
		this.username = username;
		this.password = password;
	}
	//getters/setters
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
	
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	//class specific
	
	//TODO: newPost(Post p)
		//List<Group> getGroups()
		//void addGroup(Group g)
		//void removeGroup(Group g)
	public boolean verifyPassword(String attempt) {
		if(attempt.equals(password))
			return true;
		return false;
	}
	public void changePassword(String newPwd) {
		password = newPwd;
	}
	
	
}
