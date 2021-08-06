package com.hayden.controllerspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DojoController {

	public static void main(String[] args) {
		SpringApplication.run(ControllerspracticeApplication.class, args);
	}
	
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		return "The " +dojo+" is awesome!";
	}
	
	@RequestMapping("/{dojo}/{location}")
	public String burbank(@PathVariable("dojo") String dojo, @PathVariable("location") String location ) {
		if (location.equals("burbank")) {
			String loc = location.substring(0, 1).toUpperCase() + location.substring(1);
			String capitalizeDojo = dojo.substring(0,1).toUpperCase() + dojo.substring(1);
			return loc+" "+capitalizeDojo+" is located in Southern California.";
		}
		if(location.equals("sanjose")) {
			String loc = location.substring(0, 1).toUpperCase() + location.substring(3, 4).toUpperCase();
			return loc+" "+dojo+" is the headquarters.";
		}
		return "";
	}
	
	
	
	

}
