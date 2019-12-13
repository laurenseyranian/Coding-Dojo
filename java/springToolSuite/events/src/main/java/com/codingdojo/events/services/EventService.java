package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.EventRepository;
import com.codingdojo.events.repositories.MessageRepository;
import com.codingdojo.events.repositories.UserRepository;

@Service
public class EventService {
//--------------------------------------------------------------------------------------------
// Attributes
//--------------------------------------------------------------------------------------------	
	private final EventRepository eventRepository;
	private final MessageRepository messageRepository;
	private final UserRepository userRepository;

	// -----------------------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------------------
	public EventService(EventRepository eventRepository, MessageRepository messageRepository,
			UserRepository userRepository) {
		this.eventRepository = eventRepository;
		this.messageRepository = messageRepository;
		this.userRepository = userRepository;
	}

//  -----------------------------------------------------------------------------------------
//  CREATE event
//  -----------------------------------------------------------------------------------------
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

//--------------------------------------------------------------------------------------------
// CREATE message and ADD to an event
//--------------------------------------------------------------------------------------------	   
	public Message createMessage(Message createMessage) {
		return messageRepository.save(createMessage);
	}
//  -----------------------------------------------------------------------------------------
//  UPDATE an event
//  -----------------------------------------------------------------------------------------
	public Event updateEvent(Event event) {
		return this.eventRepository.save(event);

	}

//  -----------------------------------------------------------------------------------------
//  UPDATE an user 
//  -----------------------------------------------------------------------------------------
	public void updateUser(User attendee) {
		userRepository.save(attendee);

	}

//  -----------------------------------------------------------------------------------------
//  DELETE event by ID
//  -----------------------------------------------------------------------------------------
	public void deleteEvent(Long event_id) {
		eventRepository.deleteById(event_id);
	}
	
//  -----------------------------------------------------------------------------------------
//  DELETE event by ID
//  -----------------------------------------------------------------------------------------
	public void deleteComment(Long comment_id) {
		messageRepository.deleteById(comment_id);
	}
//  -----------------------------------------------------------------------------------------
//  FIND user by ID
//  -----------------------------------------------------------------------------------------
	public User findUserById(Long userId) {
		Optional<User> u = userRepository.findById(userId);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

//  -----------------------------------------------------------------------------------------
//  FIND event by ID
//  -----------------------------------------------------------------------------------------
	public Event findEventById(Long event_id) {
		return eventRepository.findEventById(event_id);
	}

//  -----------------------------------------------------------------------------------------
//  FIND event in state
//  -----------------------------------------------------------------------------------------
	public List<Event> eventsInState(String state) {
		return eventRepository.findByState(state);
	}

//  -----------------------------------------------------------------------------------------
//  FIND event out of state
//  -----------------------------------------------------------------------------------------
	public List<Event> eventsOutOfState(String state) {
		return eventRepository.findByStateIsNot(state);
	}
//  -----------------------------------------------------------------------------------------
//  FIND comment by ID
//  -----------------------------------------------------------------------------------------
	public Message findCommentById(Long comment_id) {
		return messageRepository.findById(comment_id).orElse(null);
	}
////  -----------------------------------------------------------------------------------------
////  FIND comment by ID and order it by created at
////  -----------------------------------------------------------------------------------------
//	public List <Message> findAllByOrderByCreatedAt() {
//		return messageRepository.findAllByOrderByCreatedAtAsc();
//	}
//  -----------------------------------------------------------------------------------------
//  ADD message to an event
//  -----------------------------------------------------------------------------------------
	public void addMessageToEvent (Message message_id) {
		
	}
}
