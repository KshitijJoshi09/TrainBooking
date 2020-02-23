package com.booking.app.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.app.config.Constants;
import com.booking.app.dto.User;
import com.booking.app.service.UserService;
import com.booking.app.util.AuthenticationRequest;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/displaySignInPage")
	String signInPageMethod() {
		
		return "signInPage";
	}
	
	@RequestMapping(value = "/signIn" , method =RequestMethod.POST)
	String signIn(AuthenticationRequest request , HttpServletResponse resp 
			, HttpSession httpSession) {		
	//	System.out.println("login info " + request);

	User userFromDB = 	userService
		.findUserByEmailOrMobileNoOrUserName(request.getLoginCredentials());
	
	System.out.println("userFromDB -> " +userFromDB);
	// logic for Authentication 
	if(userFromDB != null 
			&& ! request.getPassword().equals(userFromDB.getPassword())) {
		return "signInPage";
	}
	
	
	
	
//	Cookie userNameCookie  = new Cookie("user", request.getLoginCredentials());
//	userNameCookie.setMaxAge(24*60*60);
//	resp.addCookie(userNameCookie);
//	
//	// beforing adding password into cookie hash the paswword
//	Cookie passwordCookie  = new Cookie("password", request.getPassword());
//	passwordCookie.setMaxAge(24*60*60);
//	resp.addCookie(passwordCookie);
	
	httpSession.setAttribute("userData", userFromDB );
	
	// logic for Authorization
	if(userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_ADMIN)) {
		return "adminDashboardPage";
	}
	else if(userFromDB != null &&userFromDB.getRole().equals(Constants.ROLE_USER)) {
		return "userDashboardPage";
	}
	
	
	
	
	
		return "signInPage";
	}
	
	

}
