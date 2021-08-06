package com.hayden.controllerspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ControllerspracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerspracticeApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		return "You searched for: " + searchQuery;
	}
	
//	@RequestMapping("/hello")
//	public String hello() {
//		return "Hello world! What route did you use to access me?";
//	}
//	
//	@RequestMapping("/goodbye")
//	public String world() {
//		return "Goodbye world!";
//	}

}
