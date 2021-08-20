package com.hayden.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.beltreview.models.Event;
import com.hayden.beltreview.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	// Create
	public Event createEvent(Event e) {
		return eventRepository.save(e);
	}
	
	// Read By State
	public List<Event> getEventsByState(String state) {
		return eventRepository.findAllByEventState(state);
	}
	
	// Read out-of-state events
	public List<Event> getOutOfStateEvents(String state) {
		return eventRepository.findAllByEventStateNotContains(state);
	}
	
	// Read One
	public Event getOneEvent(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
		
		if(optionalEvent.isPresent()) {
			Event event = (Event) optionalEvent.get();
			return event;
		}
		else {
			return null;
		}
	}
	
	// add a host
	public Event addHost(Event e) {
		return eventRepository.save(e);
	}
	
	// add an attendee
	public Event addAttendee(Event e) {
		return eventRepository.save(e);
	}
	
	// Delete Event
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
}
