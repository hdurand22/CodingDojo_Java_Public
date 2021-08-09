package com.hayden.displaydate;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		int dayNum = date.getDay();
		int monthNum = date.getMonth();
		int year  = date.getYear()+1900;
		String day = "";
		String month = "";
		
		if (dayNum == 0) {
			day = "Sunday";
		}
		else if (dayNum == 1) {
			day = "Monday";
		}
		else if (dayNum == 2) {
			day = "Tuesday";
		}
		else if (dayNum == 3) {
			day = "Wednesday";
		}
		else if (dayNum == 4) {
			day = "Thursday"; 
		}
		else if (dayNum == 5) {
			day = "Friday";
		}
		else {
			day = "Saturday";
		}
		
		if (monthNum == 0) {
			month = "January";
		}
		else if (monthNum == 1) {
			month = "February";
		}
		else if (monthNum == 2) {
			month = "March";
		}
		else if (monthNum == 3) {
			month = "April";
		}
		else if (monthNum == 4) {
			month = "May";
		}
		else if (monthNum == 5) {
			month = "June";
		}
		else if (monthNum == 6) {
			month = "July";
		}
		else if (monthNum == 7) {
			month = "August";
		}
		else if (monthNum == 8) {
			month = "September";
		}
		else if (monthNum == 9) {
			month = "October";
		}
		else if (monthNum == 10) {
			month = "November";
		}
		else if (monthNum == 11) {
			month = "December";
		}
		
		
		model.addAttribute("day", day);
		model.addAttribute("date", date.getDate());
		model.addAttribute("month", month);
		model.addAttribute("year", year);
		
		return"date.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		int hour = date.getHours();
		String amPM = "AM";
		
		if (hour >= 12) {
			amPM = "PM";
		}
		if (hour > 12) {
			hour = hour-12;
		}
		
		model.addAttribute("hour", hour);
		model.addAttribute("minute", date.getMinutes());
		model.addAttribute("amPM", amPM);
		return "time.jsp";
	}
}
