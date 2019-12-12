package com.codingdojo.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
//----------------------------------------------------------------
//	Attributes
//----------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message="Enter event name")
	private String name; 
	
	@FutureOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Size(min = 2, message="City must be more than 2 characters")
	private String city;
	
	private String state; 
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
//----------------------------------------------------------------
//	Relationships
//----------------------------------------------------------------
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Message> messages;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_events", 
		joinColumns = @JoinColumn(name = "event_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)     
	private List<User> attendees;
	
//----------------------------------------------------------------
//	Constructors
//----------------------------------------------------------------
	public Event() {
	}

	public Event(Long id, String name, Date date, String city, String state, Date createdAt, Date updatedAt, List<Message> messages, User host,List<User> attendees) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.city = city;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.messages = messages;
		this.host = host;
		this.attendees = attendees;
	}
	
//----------------------------------------------------------------
//		Getters and Setters
//----------------------------------------------------------------  
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
}
