package com.hayden.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.beltreview.models.Event;
import com.hayden.beltreview.models.User;
import com.hayden.beltreview.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// Register user and hash pw
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	
	// Find user by email
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	// Find user by ID
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		}
		else {
			return null;
		}
 	}
	
	// Authenticate user
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	// Update user (i.e. attend an event or host an event)
	public User updateUser(User u) {
		return userRepository.save(u);
	}
	
	// Get event attendees
	public List<User> getAttendees(Event e) {
		return userRepository.findAllByAttendedEvents(e);
	}
}
