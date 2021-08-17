package com.kara.events.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="messages")
public class Message {
	//ATTRIBUTE ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //ATTRIBUTE MESSAGE
    @NotEmpty(message="Message is required!")
    private String message;
    
    //ATTRIBUTE AUTHOR (One author can have many comments)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id", referencedColumnName="id", nullable=false)
	 private User author; //this comes from User > mapped by "author"
    
	//ATTRIBUTE EVENT (One event can have many comments)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="event_id", referencedColumnName="id", nullable=false)
	 private Event event; //this comes from Event > mapped by "event"

    //BEAN
    public Message() {
    }
    //POJO
    public Message(String message, User author, Event event) {
    	this.message = message;
    	this.author = author;
    	this.event = event;
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


}
