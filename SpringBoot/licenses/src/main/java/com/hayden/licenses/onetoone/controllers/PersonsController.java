package com.hayden.licenses.onetoone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hayden.licenses.onetoone.models.License;
import com.hayden.licenses.onetoone.models.Person;
import com.hayden.licenses.onetoone.services.LicenseService;
import com.hayden.licenses.onetoone.services.PersonService;

@Controller
public class PersonsController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	// Splash screen
	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("newPerson") Person person) {
		return "/licenses/newperson.jsp";
	}
	
	// Create person
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute("newPerson") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/licenses/newperson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	// Details
	@RequestMapping("/persons/{id}")
	public String personDetails(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		License license = person.getLicense();
//		System.out.println("license state: " + license.getState());
		model.addAttribute("license", license);
		return "/licenses/details.jsp";
	}
	
	// Render new license page
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("newLicense") License license, Model model) {
		List<Person> allPeople = personService.allPeople();
		model.addAttribute("people", allPeople);
		return "/licenses/newlicense.jsp";
	}
	
	// Create license
	@RequestMapping(value="/addLicense", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("newLicense") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "/licenses/newlicense.jsp";
		}
		else {
			License newLicense = licenseService.createLicense(license);
			Long id = newLicense.getId();
			String licenseNumber = String.format("%06d", id);
			newLicense.setNumber(licenseNumber);
			licenseService.updateLicense(newLicense);
			return "redirect:/persons/new";
		}
	}
	
}
