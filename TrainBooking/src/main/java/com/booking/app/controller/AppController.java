package com.booking.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	String entryPoint(){
		
		System.out.println("Entry point of Project");
		return "index";
		
	}
	
	
}
