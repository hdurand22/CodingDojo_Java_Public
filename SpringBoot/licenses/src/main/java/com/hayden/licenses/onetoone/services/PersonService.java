package com.hayden.licenses.onetoone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hayden.licenses.onetoone.models.Person;
import com.hayden.licenses.onetoone.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// Create
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	// Read all
	public List<Person> allPeople() {
		return personRepository.findAll();
	}
	
	// Read one
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
	
	// Update
	
	// Delete
}
