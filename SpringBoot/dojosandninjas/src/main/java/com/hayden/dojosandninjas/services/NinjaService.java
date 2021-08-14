package com.hayden.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.dojosandninjas.models.Ninja;
import com.hayden.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	// Create
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	// Read All
	public List<Ninja> getStudents() {
		return ninjaRepository.findAll();
	}
}
