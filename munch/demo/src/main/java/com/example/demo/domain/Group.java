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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "GroupTable")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long groupID;

	@ManyToMany(mappedBy = "groups")
	private Set<User> users;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event_group")
	@JsonIgnore
	private List<Event> events;

	private String name;

	public Group() {
		super();

		this.users = new HashSet<User>(0);
		this.events = new ArrayList<Event>();
		this.name = "";
	}

	public Group(Set<User> users, List<Event> events, String name) {
		super();
		this.users = users;
		this.events = events;
		this.name = name;
	}

	// getters/setters

	public long getGroupID() {
		return groupID;
	}

	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
