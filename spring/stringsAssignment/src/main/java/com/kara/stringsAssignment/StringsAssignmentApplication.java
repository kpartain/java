package com.kara.stringsAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
//1. Annotation
@RestController
public class StringsAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsAssignmentApplication.class, args);
	}
    // 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "a nice message";
    }
 // 1. Annotation
    @RequestMapping("/random")
    // 3. Method that maps to the request route above
    public String helloSpringBoot() { // 3
            return "a nice message about Spring Boot";
    }
}
