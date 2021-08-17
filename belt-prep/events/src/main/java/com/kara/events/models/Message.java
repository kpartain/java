package com.kara.events.models;

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

@Entity
@Table(name="messages")
public class Message {
	//ATTRIBUTE ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //ATTRIBUTE MESSAGE
    private String message;
    
    //ATTRIBUTE AUTHOR (One author can have many comments)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User author;
    
	//ATTRIBUTE EVENT (One event can have many comments)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="event_id")
	 private Event event;
	 
    //UPDATED/CREATED
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //BEAN
    public Message() {
    }
    //POJO
    public Message(String message, User author, Event event) {
    	this.message = message;
    	this.author = author;
    	this.event = event;
    }
    
    //Setter for UPDATED/CREATED
    @PrePersist
		public void onCreate() {
			this.createdAt = new Date();
		}

	@PreUpdate
		public void onUpdate() {
			this.updatedAt = new Date();
		}
	
	
	//Relationships
	
	
    // Getters/Setters OTHER
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
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
	
}
