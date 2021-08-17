package com.hayden.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hayden.loginandregistration.models.User;
import com.hayden.loginandregistration.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// Render registration page
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "/loginandregistration/registrationPage.jsp";
	}
	
	// Render login page
	@RequestMapping("/login")
	public String login() {
		return "/loginandregistration/loginPage.jsp";
	}
	
	// Handle registration request
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "/loginandregistration/registrationPage.jsp";
		}
		else {
			userService.registerUser(user);
			session.setAttribute("user_id", user.getId());
			return "redirect:/login";
		}
	}
	
	// Handle login request
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, 
							@RequestParam("password") String password, 
							Model model, 
							HttpSession session,
							RedirectAttributes redirectAttributes) {
		if (!userService.authenticateUser(email, password)) {
			redirectAttributes.addFlashAttribute("error", "There was an error logging you in.");
			return "redirect:/login";
		}
		else {
			User user = userService.findByEmail(email);
			session.setAttribute("user_id", user.getId());
			return "redirect:/home";
		}
	}
	
	
	// Render logged in user home page
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId != null) {
			User loggedInUser = userService.findUserById(userId);
			model.addAttribute("user", loggedInUser);
			return "/loginandregistration/homepage.jsp";
		}
		else {
			return "redirect:/login";
		}
	}
	
	// Handle logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
