package com.kara.events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.events.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private final MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
}
