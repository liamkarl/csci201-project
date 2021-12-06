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
@Table(name = "EventTable")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long eventID;

	// private Ordered_Map<Integer, Bookmark> proposedRestaurants

	private String startTime, endTime;
	private boolean closed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_group")
	private Group event_group;

	public Event() {
		super();

		this.startTime = "";
		this.endTime = "";

		this.closed = false;

		this.event_group = new Group();
	}

	public Event(String startTime, String endTime, boolean closed, Group group) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.closed = closed;
		this.event_group = group;
	}

	// getters/setters

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Group getGroup() {
		return event_group;
	}

	public void setGroup(Group group) {
		this.event_group = group;
	}
}
