package com.kara.events.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.events.models.Event;
import com.kara.events.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> getAll(){
		return (List<Event>) eventRepository.findAll();
	}

	public List<Event> findAllByState(String includeState) {
		List<Event> returnEvent = new ArrayList<Event>();
		List<Event> allEvents = this.getAll();
		for(Event eachEvent : allEvents) {
			if(eachEvent.getEventState().equals(includeState)) {
				returnEvent.add(eachEvent);
			}
		}
		return returnEvent;
	}

	public List<Event> findAllNotInState(String excludeState) {
		List<Event> returnEvent = new ArrayList<Event>();
		List<Event> allEvents = this.getAll();
		for(Event eachEvent : allEvents) {
			if(!eachEvent.getEventState().equals(excludeState)) {
				returnEvent.add(eachEvent);
			}
		}
		return returnEvent;
	}

	public void addEvent(Event event) {
		eventRepository.save(event);
		
	}
	
	public Event findById(Long id) {
		Optional<Event> foundItem = eventRepository.findById(id);
		if(foundItem.isPresent()) {
			return foundItem.get();
		} else {
			System.out.println("Not found in Service");
			return null;
		}
	}
	
	public void delete(Event thisEvent) {
		eventRepository.delete(thisEvent);
	}
	
	
}
