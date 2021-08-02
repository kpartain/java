package com.kara.getFamiliar.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//Create another controller named 'DojoController'. For the routes below, use the @PathVariable annotation.
public class DojoController {
	@RequestMapping("/{userinput}")
	@ResponseBody
	//'http://localhost:8080/dojo' display a text that says 'The dojo is awesome!'.
	public String op1(@PathVariable("userinput") String userinput) {
		String returnString = getStringToDisplay(userinput);
		return returnString;
	}

	private String getStringToDisplay(String userInput) {
		String returnString = "";
		//'http://localhost:8080/dojo' display a text that says 'The dojo is awesome!'.
		if(userInput.equals("dojo")) {
			returnString =  "The dojo is awesome!";
		//'http://localhost:8080/burbank-dojo/' display a text that says 'Burbank Dojo is located in Southern California'.
		} else if (userInput.equals("burbank-dojo")) {
			returnString = "Burbank Dojo is located in Southern California";
		//'http://localhost:8080/san-jose/' display a text that says 'SJ dojo is the headquarters'.
		} else if (userInput.equals("san-jose")) {
			returnString = "SJ dojo is the headquarters";
		}
		return returnString;
	}

}
