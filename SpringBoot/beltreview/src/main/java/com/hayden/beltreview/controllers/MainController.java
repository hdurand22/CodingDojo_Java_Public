package com.hayden.beltreview.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hayden.beltreview.models.Event;
import com.hayden.beltreview.models.User;
import com.hayden.beltreview.services.EventService;
import com.hayden.beltreview.services.UserService;
import com.hayden.beltreview.validators.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;

	public MainController(UserService userService, 
						UserValidator userValidator, 
						EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService = eventService;
	}
	
	// Render Welcome page
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "/beltreview/index.jsp";
	}
	
	// Handle registration
	@PostMapping("/register")
	public String registerUser(@Valid 
					@ModelAttribute("user") User user, 
					BindingResult result, 
					HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "/beltreview/index.jsp";
		}
		else {
			User u = userService.registerUser(user);
			session.setAttribute("user_id", u.getId());
			return "redirect:/events";
		}
	}
	
	// Handle login request
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email,
						@RequestParam("password") String password,
						Model model,
						HttpSession session,
						RedirectAttributes redirectAttributes) {
		if (!userService.authenticateUser(email, password)) {
			redirectAttributes.addFlashAttribute("error", "There was a problem logging you in.");
			return "redirect:/";
		}
		else {
			User u = userService.findUserByEmail(email);
			session.setAttribute("user_id", u.getId());
			return "redirect:/events";
		}
	}
	
	// Render Events page
	@GetMapping("/events")
	public String events(@ModelAttribute("newEvent") Event event, 
					Model model, 
					HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		
		if (userId == null) {
			return "redirect:/";
		}
		User loggedInUser = userService.findUserById(userId);
		model.addAttribute("user", loggedInUser);
		List<Event> stateEvents = eventService.getEventsByState(loggedInUser.getState());
		model.addAttribute("stateEvents", stateEvents);
		List<Event> outOfStateEvents = eventService.getOutOfStateEvents(loggedInUser.getState());
		model.addAttribute("outOfStateEvents", outOfStateEvents);
		return "/beltreview/events.jsp";
	}
	
	// Handle adding an event
	@PostMapping("/newEvent")
	public String addEvent(@Valid 
						@ModelAttribute("newEvent") Event event, 
						BindingResult result, 
						HttpSession session) {
		if (result.hasErrors()) {
			return "/beltreview/events.jsp";
		}
		else {
			Long userId = (Long) session.getAttribute("user_id");
			User u = userService.findUserById(userId);
			u.getHostedEvents().add(event);
			event.setHost(u);
			eventService.addHost(event);
			return "redirect:/events";
		}
	}
	
	// Render event details
	@GetMapping("/events/{id}")
	public String eventDetails(@PathVariable("id") Long id, Model model) {
		Event event = eventService.getOneEvent(id);
		
		if(event == null) {
			return "/beltreview/events.jsp";
		}
		model.addAttribute("event", event);
		List<User> attendees = userService.getAttendees(event);
		model.addAttribute("attendees", attendees);
		return "/beltreview/eventDetails.jsp";
	}
	
	// Handle adding an attendee
	@RequestMapping(value="/attendEvent/{id}", method=RequestMethod.PUT)
	public String addAttendee(@PathVariable("id") Long eventId, 
							HttpSession session) {
		
		Event event = eventService.getOneEvent(eventId);
		Long userId = (Long) session.getAttribute("user_id");
		User u = userService.findUserById(userId);
		event.getAttendees().add(u);
		u.getAttendedEvents().add(event);
		eventService.addAttendee(event);
		userService.updateUser(u);
		
		return "redirect:/events";
	}
	
	// Delete an event
	@RequestMapping(value="/cancelEvent/{id}", method=RequestMethod.DELETE)
	public String cancelEvent(@PathVariable("id") Long eventId) {
		eventService.deleteEvent(eventId);
		return "redirect:/events";
	}
	
	
	
	
}
