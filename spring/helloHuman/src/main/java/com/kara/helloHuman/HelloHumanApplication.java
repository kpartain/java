package com.kara.helloHuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
//1. Annotation
@RestController
@RequestMapping("/")
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	// 1. Annotation
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String hello() { 
    	String returnThis = "Hello Human!" + '\n' + "Welcome To Spring Boot!";
    	return returnThis;
    }
    
    @RequestMapping("{name}")
    public String namesDisplayed(@PathVariable("name") String name) {
    	String returnString = "Hello " + name +  "! Welcome to SpringBoot!";
    	return returnString;
    }

}
