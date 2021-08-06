package com.kara.dojosNinjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="dojos")
public class Dojo implements java.io.Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
    private Integer id;
	
	//name - required, 3-20 characters
	@NotNull
    @Size(min = 3, max = 20)
	@Column(name="name", nullable=false)
    private String name;
	
	@Column(name="created_at", updatable=false)
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	public Dojo() {
		//null for bean
	}
	
	public Dojo(String name) {
		this.name = name;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
