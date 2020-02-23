package com.booking.app.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.app.config.Constants;
import com.booking.app.dto.User;
import com.booking.app.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	String entryPoint(HttpServletRequest request, HttpServletResponse response) {

		String userCred = "";
		String password = "";
//
//		Cookie[] cookies = request.getCookies();
//
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("user")) {
//					userCred = cookie.getValue();
//				} else if (cookie.getName().equals("password")) {
//					password = cookie.getValue();
//				}
//			}
//		}
//
//		// get object from dataBAse and check for authentication and authrization
		HttpSession httpSession = request.getSession();
		User userFromSession =  (User)httpSession.getAttribute("userData");
		System.out.println(userFromSession);
		
		
//		
//		if (userCred.length() > 0 && password.length() > 0) {
//			User userFromDB = userService.findUserByEmailOrMobileNoOrUserName(userCred);
//			if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_ADMIN)) {
//				return "adminDashboardPage";
//			} else if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_USER)) {
//				return "userDashboardPage";
//			}
//		}
//		
		
		
		
		System.out.println("Entry point of Project");
		return "index";

	}

}
