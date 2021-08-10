package com.hayden.counter;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count =  (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
//		System.out.println(session.getAttribute("count"));
		return "index.jsp";
	}
	
	@RequestMapping(value="/resetCount", method=RequestMethod.POST)
	public String resetCount(HttpSession session) {
		session.setAttribute("count", null);
		return "redirect:/";
	}
	
	@RequestMapping("/counter")
		public String counter(HttpSession session, Model model) {
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count", count);
			return "counter.jsp";
		}
	
	@RequestMapping("/countbytwo")
		public String countByTwo(HttpSession session, Model model) {
		Integer countByTwo = (Integer) session.getAttribute("count")+2;
		model.addAttribute("countByTwo", countByTwo);
		return "countbytwo.jsp";
	}
}
