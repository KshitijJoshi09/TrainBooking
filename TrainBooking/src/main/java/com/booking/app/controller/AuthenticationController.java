package com.booking.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.app.util.AuthenticationRequest;

@Controller
public class AuthenticationController {
	
	
	@RequestMapping("/displaySignInPage")
	String signInPageMethod() {
		return "signInPage";
	}
	
	
	@RequestMapping(value = "/signIn" , method =RequestMethod.POST)
	String signIn(AuthenticationRequest request) {
		System.out.println("login info " + request);
		return "signInPage";
	}
	
	

}
