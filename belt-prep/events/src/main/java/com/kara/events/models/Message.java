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
    
	//ATTRIBUTE AUTHOR (One event can have many comments)
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

}
