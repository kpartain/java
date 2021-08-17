package com.kara.events.models;

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

@Entity
@Table(name="events")
public class Event {
	//ATTRIBUTE ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //ATTRIBUTE NAME
    private String name;
    
    //ATTRIBUTE DATE OF EVENT
    private Date eventDate;
    
    //ATTRIBUTE LOCATION CITY
    private String eventCity;
    
    //ATTRIBUTE LOCATION STATE
    private String eventState;
    
    //ATTRIBUTE HOST (one user can host many events, each event can have one host)
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User host;
    
    //ATTRIBUTE ATTENDEES (one event can have many users, one user can attend many events)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_users", 
            joinColumns = @JoinColumn(name = "event_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> attendees;
    
    //ATTRIBUTE MESSAGES (one event can have many messages, each message left by a single user)
    @OneToMany(mappedBy="messages", fetch = FetchType.LAZY)
    private List<Message> messages;
    
    //UPDATED/CREATED
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //BEAN
    public Event() {
    	//bean
    }
    //POJO
    public Event(String name, Date eventDate, String eventCity, String eventState, User host){
    	this.name = name;
    	this.eventDate = eventDate;
    	this.eventCity = eventCity;
    	this.eventState = eventState;
    	this.host = host;
    }
    
    //Created/Updated
    @PrePersist
		public void onCreate() {
			this.createdAt = new Date();
		}

	@PreUpdate
		public void onUpdate() {
			this.updatedAt = new Date();
		}
    //Relationships
	public List<User> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
    
    //Others
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
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventCity() {
		return eventCity;
	}
	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}
	public String getEventState() {
		return eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
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
