package com.example.demo.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GroupTable")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long groupID;

	@ManyToMany(mappedBy = "group")
	private Set<User> users;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private List<Event> events;

	private String name;

	public Group() {

	}

	public Group(String name) {
		this.name = name;
	}

	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}

	public long getGroupID() {
		return groupID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
