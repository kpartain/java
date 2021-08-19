package com.kara.events.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.events.models.Message;
import com.kara.events.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private final MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public void save(Message newmessage) {
		messageRepository.save(newmessage);
		
	}
}
