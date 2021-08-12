package com.kara.languages.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//DB will handle created at/updated at so they are omitted from this code
//this assignment does not call for these to be attributes or returned from DB

@Entity
@Table(name="languages")
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name="language_generator", sequenceName="languages_id_seq", allocationSize = 1)
//	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="language_generator")
	@Column(name="id", nullable=false, unique=true)
    private Integer id;
	
	//name - required, 3-20 characters
	@NotNull
    @Size(min = 3, max = 20)
	@Column(name="name", nullable=false)
    private String name;
	
	//creator - required, 3-20 characters - PERSISTED AS ONE COLUMN PER ASSIGNMENT
	@NotNull
    @Size(min = 3, max = 20)
	@Column(name="creator", nullable=false)
    private String creator;
	
	//version - required
	@NotBlank
	@Column(name="version", nullable=false)
    private String version;
	
	
	//BEAN
	public Language() {
	}
	
	//POJO
	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCreator() {
		return this.creator;
	}
	public String getVersion() {
		return this.version;
	}
	public void setId(Integer thisValue) {
		this.id = thisValue;
	}
	public void setName(String thisValue) {
		this.name = thisValue;
	}
	
	public void setCreator(String thisValue) {
		this.creator = thisValue;
	}
	
	public void setVersion(String thisValue) {
		this.version = thisValue;
	}
}
