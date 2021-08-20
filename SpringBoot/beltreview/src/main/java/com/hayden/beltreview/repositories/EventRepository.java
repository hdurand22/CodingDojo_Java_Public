package com.hayden.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hayden.beltreview.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	
	List<Event> findAllByEventState(String state);
	
	List<Event> findAllByEventStateNotContains(String state);
	
	
}
