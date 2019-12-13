package com.codingdojo.tasks.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.Size;


@Entity
@Table(name = "tasks")
public class Task {
//----------------------------------------------------------------
//	Attributes
//----------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, message = "Enter task name")
	private String task_name;
	
	private Boolean completed;

	private String priority;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
//----------------------------------------------------------------
//	Relationships
//----------------------------------------------------------------
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="creator_id")
	private User creator;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assignee_id")
	private User assignee;
	
//----------------------------------------------------------------
//	Constructors
//----------------------------------------------------------------
	public Task() {}
	
	public Task(Long id, String task_name, Boolean completed, String priority, Date createdAt, Date updatedAt, User creator, User assignee) {
	this.id = id;
	this.task_name = task_name;
	this.completed = completed;
	this.priority = priority;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.creator = creator;
	this.assignee = assignee;
}


//----------------------------------------------------------------
//	Getters and Setters
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


	public String getTask_name() {
		return task_name;
	}


	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}


	public Boolean getCompleted() {
		return completed;
	}


	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
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


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public User getAssignee() {
		return assignee;
	}


	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
}
