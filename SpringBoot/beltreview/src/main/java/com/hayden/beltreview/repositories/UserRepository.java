package com.hayden.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hayden.beltreview.models.Event;
import com.hayden.beltreview.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	
	List<User> findAll();
	
	List<User> findAllByAttendedEvents(Event event);
	
}
