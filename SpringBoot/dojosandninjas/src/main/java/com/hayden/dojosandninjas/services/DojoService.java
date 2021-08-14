package com.hayden.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.dojosandninjas.models.Dojo;
import com.hayden.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	
	// Create
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	// Read All
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	// Read One
	public Dojo getOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}
