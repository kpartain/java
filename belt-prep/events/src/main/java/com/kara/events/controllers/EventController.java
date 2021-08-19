package com.kara.events.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.events.models.Event;
import com.kara.events.models.Message;
import com.kara.events.models.USStates;
import com.kara.events.models.User;
import com.kara.events.services.EventService;
import com.kara.events.services.MessageService;
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
	
	@Autowired 
	private MessageService messageService;
	
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
	@RequestMapping("/{id}/delete")
    public String deleteSingleEvent(@PathVariable("id") Long id, HttpSession session) {
		Long currentUsersID = (Long) session.getAttribute("user_id");
    	Event thisEvent = eventService.findById(id);
    	System.out.println(id);
    	System.out.println(currentUsersID);
    	User thisUser = userService.findById(currentUsersID);
    	if(thisEvent.getHost().equals(thisUser)) {
    		eventService.delete(thisEvent);
    		return "redirect:/events";
    	} else {
    		System.out.println("Unable to delete someone else's event");
    		return "redirect:/events";
    	}
    	
    }
	
	//attend event
	@GetMapping("/{event_id}/add/{user_id}")
	public String userRSVP(@PathVariable("event_id")Long eventID, @PathVariable("user_id")Long userID) {
		User thisUser = userService.findById(userID);
		Event thisEvent = eventService.findById(eventID);
		thisEvent.getAttendees().add(thisUser);
		//update/save are the same
		eventService.addEvent(thisEvent);
		return "redirect:/events";
	}
	
	//un-attend event
	@GetMapping("/{event_id}/remove/{user_id}")
	public String userUnRSVP(@PathVariable("event_id")Long eventID, @PathVariable("user_id")Long userID) {
		User thisUser = userService.findById(userID);
		Event thisEvent = eventService.findById(eventID);
		thisEvent.getAttendees().remove(thisUser);
		//update/save are the same
		eventService.addEvent(thisEvent);
		return "redirect:/events";
	}
	
	//show page
	@GetMapping("/{id}")
	public String showPageEvent(@PathVariable("id")Long id, HttpSession session, Model model) {
		Long currentUsersID = (Long) session.getAttribute("user_id");
    	User thisUser = userService.findById(currentUsersID);
    	Event thisEvent = eventService.findById(id);
    	System.out.println(id);
    	System.out.println(currentUsersID);
    	model.addAttribute("currentUser", thisUser);
    	model.addAttribute("event", thisEvent);
    	Message newMessage = new Message();
    	model.addAttribute("newmessage", newMessage);
    	return "3-events-show-page.jsp";
	}
	
	//add a comment
	@RequestMapping(value="/{id}/post-message", method=RequestMethod.POST)
	public String addAComment(@Valid @ModelAttribute("newmessage") Message newmessage, @PathVariable("id")Long id, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			//same logic for show page
			Long currentUsersID = (Long) session.getAttribute("user_id");
	    	User thisUser = userService.findById(currentUsersID);
	    	Event thisEvent = eventService.findById(id);
	    	System.out.println(id);
	    	System.out.println(currentUsersID);
	    	model.addAttribute("currentUser", thisUser);
	    	model.addAttribute("event", thisEvent);
	    	Message newMessage = new Message();
	    	model.addAttribute("newmessage", newMessage);
	    	return "3-events-show-page.jsp";
		} else {
			messageService.save(newmessage);
			return "redirect:/events/"+id;
		}
	}
	
	//edit event page render
	@GetMapping("/{id}/edit")
	public String editSingleEvent(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long currentUsersID = (Long) session.getAttribute("user_id");
    	User thisUser = userService.findById(currentUsersID);
    	model.addAttribute("currentUser", thisUser);
		Event thisEvent = eventService.findById(id);
		if(thisEvent.getHost().equals(thisUser)) {
			System.out.println(id);
			model.addAttribute("event", thisEvent);
			model.addAttribute("listOfStateCodes", stateCodes);
			return "4-edit-event.jsp";
		} else {
			return "redirect:/events";
		}
		
	}
	
	//edit event page POST
	@RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
	public String editEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
			if(result.hasErrors()) {
				Long currentUsersID = (Long) session.getAttribute("user_id");
		    	User thisUser = userService.findById(currentUsersID);
		    	model.addAttribute("currentUser", thisUser);
				model.addAttribute("event", eventService.findById(id));
				model.addAttribute("listOfStateCodes", stateCodes);
				return "edit.jsp";
			}
			else {
				eventService.addEvent(event);
				return "redirect:/events";
			}
	}
}
