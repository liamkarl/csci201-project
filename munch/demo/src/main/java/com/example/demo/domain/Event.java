package com.example.demo.domain;

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
	private long eventID;

	// private Ordered_Map<Integer, Bookmark> proposedRestaurants

	private String startTime, endTime;
	private boolean closed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group")
	private Group group;

	public Event() {
	}

	public Event(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// getters/setters

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
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

	public boolean getClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
