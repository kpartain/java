package com.kara.events.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    public LoginUser() {
    }
    
    public LoginUser(String email, String password) {
    	this.email = email;
    	this.password = password;
    }
        // TODO - Don't forget to generate getters and setters
    }
    
