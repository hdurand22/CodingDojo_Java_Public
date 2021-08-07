package com.hayden.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index(@RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {
		String greeting;
		if (firstName == null || lastName == null) {
			greeting = "<h1>Hello Human!</h1>";
		}
		else {
			greeting = "<a href='/'>Go Back</a><br/><h1>Hello "+firstName+" "+lastName+"!</h1>";
		}
		return greeting+"\n Welcome to SpringBoot!";
	}

}
