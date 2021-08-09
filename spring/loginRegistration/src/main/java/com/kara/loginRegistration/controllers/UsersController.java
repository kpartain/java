package com.kara.loginRegistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.loginRegistration.models.User;
import com.kara.loginRegistration.services.UserService;

@Controller
public class UsersController {
    private final UserService userService;
    
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration-post", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, 
    	if(result.hasErrors()) {
    		//return the registration page (don't worry about validations just now)
			return "registrationPage.jsp";
		} else {
			// else, save the user in the database,  
			User userPersisted = userService.registerUser(user);
			//save the user id in session,
			Long usersID = userPersisted.getId();
			session.setAttribute("userID", usersID);
			//and redirect them to the /home route
			return "redirect:/home";
		}
    }
    
    @RequestMapping(value="/login-post", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, 
    	if(userService.authenticateUser(email, password)) {
    		//save their user id in session
    		User userFound = userService.findByEmail(email);
    		Long usersID = userFound.getId();
			session.setAttribute("userID", usersID);
			return "redirect:/home";
    	} else {
    		// else, add error messages 
    		model.addAttribute("loginerror", "Invalid username or password");
    		//and return the login page
    		return "registrationPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user ID from session,  
    	Long thisUsersId = (Long) session.getAttribute("userID");
    	//get user object from session ID 
    	User thisUser = userService.findUserById(thisUsersId);
    	//save them in the model
    	model.addAttribute("user", thisUser);
    	//return the home page
    	return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/registration";
    }
}