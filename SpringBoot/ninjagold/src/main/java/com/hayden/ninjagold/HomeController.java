package com.hayden.ninjagold;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	ArrayList<String> activities = new ArrayList<String>();
	
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "No gold yet. Start collecting!");
		}
		else if ((int) session.getAttribute("gold") < -100) {
			return "jail.jsp";
		}
		else {
			int currentGold = (int) session.getAttribute("gold");
			model.addAttribute("totalGold", currentGold);
			activities.add(session.getAttribute("activity") + " ("+session.getAttribute("timestamp")+")\n");
			model.addAttribute("activities", activities);
//			System.out.println("activities: "+activities);
		}
//		System.out.println("activities size: "+activities.size());
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/updateGold", method=RequestMethod.POST)
	public String updateGold(HttpSession session, @RequestParam(value="location") String location) {
		int currentGold = (int) session.getAttribute("gold");
		System.out.println("location: "+location);
//		System.out.println("farm: "+farm);
//		System.out.println("cave: "+cave);
//		System.out.println("house: "+house);
//		System.out.println("casino: "+casino);
		
		if (location.equals("farm")) {
			Random r = new Random(); // Get a random number generator
			int goldToAdd = r.nextInt(11)+10;
			session.setAttribute("gold", (currentGold+goldToAdd));
			session.setAttribute("timestamp", LocalDateTime.now());
			session.setAttribute("activity", String.format("You entered the farm and earned %d gold.", goldToAdd));
		}
		else if (location.equals("cave")) {
			Random r = new Random(); // Get a random number generator
			int goldToAdd = r.nextInt(6)+5;
			session.setAttribute("gold", (currentGold+goldToAdd));
			session.setAttribute("timestamp", LocalDateTime.now());
			session.setAttribute("activity", String.format("You entered a cave and earned %d gold.", goldToAdd));
		}
		else if (location.equals("house")) {
			Random r = new Random(); // Get a random number generator
			int goldToAdd = r.nextInt(4)+2;
			session.setAttribute("gold", (currentGold+goldToAdd));
			session.setAttribute("timestamp", LocalDateTime.now());
			session.setAttribute("activity", String.format("You entered your house and earned %d gold.", goldToAdd));
		}
		else if (location.equals("casino")) {
			Random r = new Random(); // Get a random number generator
			int goldToAdd = r.nextInt(100)-50;
//			System.out.println("casino gold: "+goldToAdd);
			session.setAttribute("gold", (currentGold+goldToAdd));
			session.setAttribute("timestamp", LocalDateTime.now());
			if (goldToAdd >= 0) {
				session.setAttribute("activity", String.format("You entered a casino and earned %d gold.", goldToAdd));
			}
			else {
				session.setAttribute("activity", String.format("You entered a casino and lost %d gold.", goldToAdd));
			}
		}
		else if (location.equals("spa")) {
			Random r = new Random();
			int goldToAdd = r.nextInt(15)-20;
			session.setAttribute("gold", (currentGold+goldToAdd));
			session.setAttribute("timestamp", LocalDateTime.now());
			session.setAttribute("activity", String.format("You went to the spa and spent %d gold.", (goldToAdd*-1)));
		}
		
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/resetGold", method=RequestMethod.POST)
	public String resetGold(HttpSession session) {
		activities.clear(); // Clear the ArrayList
		session.invalidate(); // Clear the session
		return "redirect:/gold";
	}
}
