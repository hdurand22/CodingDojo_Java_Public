package com.hayden.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submitSurvey", method=RequestMethod.POST)
	public String submitSurvey(HttpSession session, @RequestParam(value="name") String name, 
							@RequestParam(value="dojoLocation") String dojoLocation, 
							@RequestParam(value="favoriteLanguage") String favoriteLanguage,
							@RequestParam(value="comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("dojoLocation", dojoLocation);
		session.setAttribute("favoriteLanguage", favoriteLanguage);
		session.setAttribute("comment", comment);
		
		if (favoriteLanguage.equals("java")) {
			return "redirect:/javaresults";
		}
		else {
			return "redirect:/result";			
		}
	}
	
	@RequestMapping("/result")
	public String submitSurvey(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("dojoLocation", session.getAttribute("dojoLocation"));
		model.addAttribute("favoriteLanguage", session.getAttribute("favoriteLanguage"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "result.jsp";
	}
	
	@RequestMapping("/javaresults")
	public String javaResults() {
		return "javaresults.jsp";
	}
	
}
