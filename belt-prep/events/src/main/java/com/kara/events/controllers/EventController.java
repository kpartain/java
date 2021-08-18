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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private final List<String> stateCodes = USStates.listOfStates;
	
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
		model.addAttribute("usersName", thisUser.getFirstName());
		//Form: states and object for data bind - set the host to the current logged in user
		Event newEvent = new Event();
		model.addAttribute("event", new Event());
		model.addAttribute("listOfStateCodes", stateCodes);
	
		// events in and out of state
		List<Event> eventsInState = eventService.findAllByState(thisUser.getState());
		model.addAttribute("eventsInState", eventsInState);
		List<Event> eventsNotInState = eventService.findAllNotInState(thisUser.getState());
		model.addAttribute("eventsNotInState", eventsNotInState);
		
		return "2-events-dashboard.jsp";
	}
	
	//post mapping to add a new event.
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addNewEventPOST(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			//Items for Tables
			Long currentUsersID = (Long) session.getAttribute("user_id");
			User thisUser = userService.findById(currentUsersID);
			model.addAttribute("currentUser", thisUser);
			model.addAttribute("usersName", thisUser.getFirstName());
			model.addAttribute("listOfStateCodes", stateCodes);
			List<Event> eventsInState = eventService.findAllByState(thisUser.getState());
			model.addAttribute("eventsInState", eventsInState);
			List<Event> eventsNotInState = eventService.findAllNotInState(thisUser.getState());
			model.addAttribute("eventsNotInState", eventsNotInState);
			return "2-events-dashboard.jsp";
			} else {
				eventService.addEvent(event);
				return "redirect:/events";
			}
	}
	//delete event
	
	//attend event
	
	//un-attend event
	
	//edit event page render
	
	//edit event page POST
}
