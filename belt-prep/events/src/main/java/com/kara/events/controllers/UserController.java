package com.kara.events.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kara.events.models.LoginUser;
import com.kara.events.models.USStates;
import com.kara.events.models.User;
import com.kara.events.services.UserService;

@Controller
public class UserController {
	//session items: user_id
	
	//list of states for form
	private final List<String> stateCodes = USStates.listOfStates;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listOfStateCodes", stateCodes);
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "1-login-register.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
	        BindingResult result, Model model, HttpSession session) {
	    userServ.register(newUser, result);
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "1-login-register.jsp";
	    }
	    session.setAttribute("user_id", newUser.getId());
	    return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	        BindingResult result, Model model, HttpSession session) {
	    User user = userServ.login(newLogin, result);
	    if(result.hasErrors()) {
	        model.addAttribute("newUser", new User());
	        return "1-login-register.jsp";
	    }
	    session.setAttribute("user_id",  user.getId());
	    return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/";
	}

}