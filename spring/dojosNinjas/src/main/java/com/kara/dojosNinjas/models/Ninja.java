package com.kara.dojosNinjas.models;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ninjas")
public class Ninja implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
    private Integer id;
	
	//first name - required
	@NotNull
	@Column(name="first_name", nullable=false)
    private String firstName;
	
	//last name - required
	@NotNull
	@Column(name="last_name", nullable=false)
    private String lastName;
	
	//age - required
	@NotNull
	@Min(1)
	@Column(name="age", nullable=false)
    private Integer age;
	
	//Dojo - many to one
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="dojo_id")
	 private Dojo dojo;
	 
	@Column(name="created_at", updatable=false)
	private Date createdAt;
		
	@Column(name="updated_at")
	private Date updatedAt;
	
	 public Ninja() {
		 //empty bean
	 }
	 
	 public Ninja(String firstName, String lastName, Integer age, Dojo dojo) {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.age = age;
		 this.dojo = dojo;
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
    
    @PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	 
	 
}
