package com.codingdojo.dojooverflow.models;

import java.util.Date;

import javax.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "answers")

//----------------------------------------------------------------
//	Attributes
//----------------------------------------------------------------
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Size(min = 2)
	private String text;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
//----------------------------------------------------------------
//	Relationships
//----------------------------------------------------------------  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
//----------------------------------------------------------------
//	Constructors
//----------------------------------------------------------------
	public Answer() {

	}
	public Answer(String answer, Question question) {
		this.text = answer;
		this.question=question;
	}
	
	public Answer(Long id, String answer, Date createdAt, Date updatedAt, Question question) {
		this.id = id;
		this.text = answer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
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
	public String getText() {
		return text;
	}
	public void setText(String answer) {
		this.text = answer;
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
	public void setId(Long id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
