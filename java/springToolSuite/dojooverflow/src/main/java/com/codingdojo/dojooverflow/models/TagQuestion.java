package com.codingdojo.dojooverflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags_questions")
public class TagQuestion {
//----------------------------------------------------------------
//	Attributes
//----------------------------------------------------------------
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
//----------------------------------------------------------------
//	Relationships
//----------------------------------------------------------------  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
//----------------------------------------------------------------
//	Constructors
//----------------------------------------------------------------  
    public TagQuestion() {
	}
	
	public TagQuestion(Question question, Tag tag) {
		this.question = question;
		this.tag = tag;
	}

	public TagQuestion(Long id, Date createdAt, Date updatedAt, Question question, Tag tag) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
		this.tag = tag;
	}
//----------------------------------------------------------------
//	Getters and Setters
//----------------------------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
   

}
