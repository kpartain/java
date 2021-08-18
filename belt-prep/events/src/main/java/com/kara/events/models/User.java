package com.kara.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name", nullable=false)
    @NotEmpty(message="First name is required!")
    @Size(min=3, max=30, message="First name must be between 3 and 30 characters")
    private String firstName;
    
    @Column(name="last_name", nullable=false)
    @NotEmpty(message="Last name is required!")
    @Size(min=3, max=30, message="Last name must be between 3 and 30 characters")
    private String lastName;
    
    //shortest are 3 letters
    //Village of Grosse Pointe Shores city longest
    @Column(name="city", nullable=false)
    @NotEmpty(message="City is required!")
    @Size(min=3, max=37, message="City must be between 3 and 36 characters")
    private String city;
    
    @Column(name="state", nullable=false)
    @NotEmpty(message="State is required!")
    @Size(min=2, max=3, message="State code can only have 2 letters")
    private String state;
    
    @Column(name="email", nullable=false)
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @Column(name="password", nullable=false)
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
  
	@Column(name="created_at", updatable=false)
	private Date createdAt;
		
	@Column(name="updated_at")
	private Date updatedAt;
	
	//ONE USER CAN LEAVE MANY MESSAGES
	@OneToMany(mappedBy="author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages;
	
	//ONE USER CAN HOST MANY EVENTS
	@OneToMany(mappedBy="host", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> hostingEvents;
	
	//MANY USERS CAN ATTEND MANY EVENTS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "attendees", 
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> attendingEvents;
	
    //BEAN
    public User() {
    	
    }
    
    //POJO
    public User(String firstName, String lastName, String city, String state, String email, String password, String confirm) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.city = city;
    	this.state = state;
    	this.email = email;
    	this.password = password;
    	this.confirm = confirm;
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
	
	//Getters/Setters Relationships

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Event> getHostingEvents() {
		return hostingEvents;
	}

	public void setHostingEvents(List<Event> hostingEvents) {
		this.hostingEvents = hostingEvents;
	}

	public List<Event> getAttendingEvents() {
		return attendingEvents;
	}

	public void setAttendingEvents(List<Event> attendingEvents) {
		this.attendingEvents = attendingEvents;
	}
	
    // Getters/Setters OTHER

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
    
