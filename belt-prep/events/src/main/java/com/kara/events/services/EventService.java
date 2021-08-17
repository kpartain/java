package com.kara.events.services;

import java.util.List;

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
		List<Event> allEvents = this.getAll();
		for(Event eachEvent : allEvents) {
			if(eachEvent.getEventState() == includeState) {
				allEvents.remove(eachEvent);
			}
		}
		return allEvents;
	}

	public List<Event> findAllNotInState(String excludeState) {
		List<Event> allEvents = this.getAll();
		for(Event eachEvent : allEvents) {
			if(eachEvent.getEventState() == excludeState) {
				allEvents.remove(eachEvent);
			}
		}
		return allEvents;
	}
}
