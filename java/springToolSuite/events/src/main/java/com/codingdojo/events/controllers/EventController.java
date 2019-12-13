package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;

@Controller
public class EventController {
//-------------------------------------------------------------------------------------------------------
// Attribute
//-------------------------------------------------------------------------------------------------------
	private final EventService eventService;
	private final UserService userService;

	// ----------------------------------------------------------------------------------------
	// Constructors
	// ----------------------------------------------------------------------------------------
	public EventController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
	}

//-------------------------------------------------------------------------------------------------------
// Dictionary for all of the states
//-------------------------------------------------------------------------------------------------------
	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
			"IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
			"NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
			"WY" };

//-------------------------------------------------------------------------------------------------------
// POST route for CREATING a new event
//-------------------------------------------------------------------------------------------------------
	@PostMapping(value = "/event/create")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User user = eventService.findUserById(userId);
			model.addAttribute("user", user);
			String state = user.getState();
			List<Event> eventsInState = eventService.eventsInState(state);
			model.addAttribute("eventsInState", eventsInState);
			List<Event> eventsOutOfState = eventService.eventsOutOfState(state);
			model.addAttribute("eventsOutOfState", eventsOutOfState);
			model.addAttribute("states", states);
			return "/events/readAll.jsp";
		} else {
			eventService.createEvent(event);
			return "redirect:/events/" + event.getId();
		}
	}

// -------------------------------------------------------------------------------------------------------
// POST route for CREATING a new comment
// -------------------------------------------------------------------------------------------------------
	@PostMapping(value = "/comment/create")
	public String createComment(@Valid @ModelAttribute("comment") Message message, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = eventService.findUserById(userId);
		model.addAttribute("user", user);
		message = eventService.createMessage(message);
		return "redirect:/events/" + message.getEvent().getId();
	}

// -----------------------------------------------------------------------------------------------------
// GET route for READING home page after user successfully login AND READING in and out of state events
// -----------------------------------------------------------------------------------------------------
	@RequestMapping("/events")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		String state = user.getState();
		List<Event> eventsInState = eventService.eventsInState(state);
		model.addAttribute("eventsInState", eventsInState);
		List<Event> eventsOutOfState = eventService.eventsOutOfState(state);
		model.addAttribute("eventsOutOfState", eventsOutOfState);
		model.addAttribute("states", states);
		return "/events/readAll.jsp";
	}

//------------------------------------------------------------------------------------------------------
// GET route for READING one event by ID
//------------------------------------------------------------------------------------------------------
	@GetMapping("/events/{event_id}")
	public String showEvent(HttpSession session, Model model, @PathVariable("event_id") Long event_id,
			@ModelAttribute("comment") Message comment) {
		Event event = eventService.findEventById(event_id);
		model.addAttribute("event", event);
		Long userId = (Long) session.getAttribute("userId");
		User user = eventService.findUserById(userId);
		model.addAttribute("user", user);
		return "/events/readOne.jsp";
	}

// ------------------------------------------------------------------------------------------------------
// GET route for UPDATING one event by ID
// ------------------------------------------------------------------------------------------------------
	@RequestMapping("/event/{event_id}/edit")
	public String editEvent(@PathVariable("event_id") Long event_id, Model model) {
		Event event = eventService.findEventById(event_id);
		model.addAttribute("event", event);
		model.addAttribute("states", states);
		return "/events/update.jsp";
	}

//------------------------------------------------------------------------------------------------------
// POST route for UPDATE one event by ID
//------------------------------------------------------------------------------------------------------    
	@PutMapping("/event/{id}/update")
	public String updateEvent(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("states", states);
			return "/events/update.jsp";
		} else {
			this.eventService.updateEvent(event);
			return "redirect:/events/" + event.getId();
		}
	}

//------------------------------------------------------------------------------------------------------
// POST route for DELETING an event by ID
//------------------------------------------------------------------------------------------------------
	@RequestMapping("/event/{event_id}/delete")
	public String deleteEvent(@PathVariable("event_id") Long event_id) {
		eventService.deleteEvent(event_id);
		return "redirect:/events";
	}

//------------------------------------------------------------------------------------------------------
// POST route for DELETING a comment by ID
//------------------------------------------------------------------------------------------------------
	@RequestMapping("/comment/{comment_id}/{event_id}/delete")
	public String deleteComment(HttpSession session, @PathVariable("comment_id") Long comment_id, @PathVariable("event_id") Long event_id) {
		if (session.getAttribute("userId").equals(eventService.findCommentById(comment_id).getUser().getId())) {
			eventService.deleteComment(comment_id);
			return "redirect:/events/" + event_id;
		}
		else {
			return "redirect:/events/" + event_id;
		}
	}

// -----------------------------------------------------------------------------------------------------
// GET route for ADDING an attendee to Event (join button)
// -----------------------------------------------------------------------------------------------------
	@GetMapping(value = "/event/{event_id}/join")
	public String addAttendee(@PathVariable("event_id") Long event_id, HttpSession session) {
		User attendee = eventService.findUserById((Long) session.getAttribute("userId"));
		Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getAttendees();
		attendees.add(attendee);
		attending_event.setAttendees(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
	}

// -----------------------------------------------------------------------------------------------------
// GET route for REMOVING an Attendee from an vent (cancel button)
// -----------------------------------------------------------------------------------------------------
	@GetMapping(value = "/event/{event_id}/cancel")
	public String removeAttendee(@PathVariable("event_id") Long event_id, HttpSession session) {
		User attendee = eventService.findUserById((Long) session.getAttribute("userId"));
		Event attending_event = eventService.findEventById(event_id);
		List<User> attendees = attending_event.getAttendees();
		attendees.remove(attendee);
		attending_event.setAttendees(attendees);
		eventService.updateUser(attendee);
		return "redirect:/events";
	}

}
