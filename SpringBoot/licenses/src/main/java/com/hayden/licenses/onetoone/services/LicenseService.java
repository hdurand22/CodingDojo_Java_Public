package com.hayden.licenses.onetoone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hayden.licenses.onetoone.models.License;
import com.hayden.licenses.onetoone.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
	// Create
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	
	// Read All
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	// Read One
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		else {
			return null;
		}
	}
	
	// Update
	public License updateLicense(License l) {
		return licenseRepository.save(l);
	}
}
