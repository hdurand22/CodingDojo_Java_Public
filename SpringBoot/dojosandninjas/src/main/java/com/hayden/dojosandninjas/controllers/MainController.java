package com.hayden.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hayden.dojosandninjas.models.Dojo;
import com.hayden.dojosandninjas.models.Ninja;
import com.hayden.dojosandninjas.services.DojoService;
import com.hayden.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public MainController(NinjaService ninjaService, DojoService dojoService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	// New Dojo Screen
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "/dojosandninjas/newdojo.jsp";
	}
	
	// Handle dojo creation POST request
	@PostMapping(value="/dojos/addDojo")
	public String addDojo(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojosandninjas/newdojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	// Render New Ninja screen
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.getAllDojos();
		model.addAttribute("dojos", allDojos);
		return "/dojosandninjas/newninja.jsp";
	}
	
	// Handle ninja creation POST request
	@PostMapping(value="/ninjas/addNinja")
	public String addNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojosandninjas/newninja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	// Render Dojo and ninjas
	@GetMapping("/dojos/{id}")
	public String showDojoDetails(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.getOneDojo(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninjasAtDojo = dojo.getNinjas();
		model.addAttribute("ninjas", ninjasAtDojo);
		return "/dojosandninjas/dojodetails.jsp";
	}
	
	
}
