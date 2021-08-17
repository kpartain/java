package com.kara.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kara.events.models.Event;
import com.kara.events.models.USStates;
import com.kara.events.models.User;
import com.kara.events.services.EventService;
import com.kara.events.services.UserService;

@Controller
@RequestMapping("/events")
public class EventController {
	//session items: user_id
	
	//list of states for form
	private final List<String> stateCodes = USStates.listOfUSStatesCode;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	//EVENTS DASHBOARD: table of events in your state. table of events NOT in your state. form to add a new event.
	@GetMapping("")
	public String showDashboard(Model model, HttpSession session) {
		
		//logged in user object & properties to reuse
		Long currentUsersID = (Long) session.getAttribute("user_id");
		User thisUser = userService.findById(currentUsersID);
		model.addAttribute("currentUser", thisUser);
		
		//Form: states and object for data bind - set the host to the current logged in user
		Event newEvent = new Event();
		newEvent.setHost(thisUser);
		model.addAttribute("event", new Event());
		model.addAttribute("listOfStateCodes", stateCodes);
		
		//Events this user is hosting and attending
		List<Event> eventsHostedByThisUser = thisUser.getHostingEvents();
		model.addAttribute("eventsHostedByThisUser", eventsHostedByThisUser);
		List<Event> eventsAttendedByThisUser = thisUser.getAttendingEvents();
		model.addAttribute("eventsAttendedByThisUser", eventsAttendedByThisUser);
		
		// events in and out of state
		List<Event> eventsInState = eventService.findAllByState(currentUsersState);
		model.addAttribute("eventsInState", eventsInState);
		List<Event> eventsNotInState = eventService.findAllNotInState(currentUsersState);
		model.addAttribute("eventsNotInState", eventsNotInState);
	}
	//post mapping to add a new event.
	
}
