package com.kara.events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.events.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
}
