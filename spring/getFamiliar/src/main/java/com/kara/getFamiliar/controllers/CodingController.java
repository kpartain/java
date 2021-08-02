package com.kara.getFamiliar.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/coding")
//Create a controller named 'CodingController'. For the first 3 routes, use the @RequestMapping annotation.
public class CodingController {
//'http://localhost:8080/coding' display a text that says 'Hello Coding Dojo!'.
	@RequestMapping("")
	public String hcd() {
		return "Hello Coding Dojo!";
	}
//'http://localhost:8080/coding/python' display a text that says 'Python/Django was awesome!'.
	@RequestMapping("/python")
	public String pdwa() {
		return "Python/Django was awesome!";
	}
//'http://localhost:8080/coding/java' display a text that says 'Java/Spring is better!'.
	@RequestMapping("/java")
	public String jsib() {
		return "Java/Spring is better!";
	}
	
}
