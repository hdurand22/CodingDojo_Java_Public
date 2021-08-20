package com.hayden.beltreview.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hosts")
public class Host extends User {
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private List<Event> hostedEvents;
	
	public Host() {
		
	}

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}
	
	
}
