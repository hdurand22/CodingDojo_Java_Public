package com.hayden.licenses.onetoone.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hayden.licenses.onetoone.models.Person;
import com.hayden.licenses.onetoone.services.LicenseService;
import com.hayden.licenses.onetoone.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicensesController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	

}
