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

		System.out.println("Entry point of Project");

		String userCred = "";
		String password = "";

		HttpSession httpSession = request.getSession();
		User userFromSession = (User) httpSession.getAttribute("userData");
		System.out.println(userFromSession);

		// if session doesn't have user Object return to dashboard directly
		// else check for the role and return to dashboard
		if (userFromSession != null) {
			if (userFromSession != null && userFromSession.getRole().equals(Constants.ROLE_ADMIN)) {
				return "adminDashboardPage";
			} else if (userFromSession != null && userFromSession.getRole().equals(Constants.ROLE_USER)) {
				return "userDashboardPage";
			}
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("user")) {
						userCred = cookie.getValue();
					} else if (cookie.getName().equals("password")) {
						password = cookie.getValue();
					}
				}
				
				if (userCred.length() > 0 && password.length() > 0) {
					
					// get the Object the from DB ,add Store the object httpSession
					User userFromDB = userService.findUserByEmailOrMobileNoOrUserName(userCred);
					httpSession.setAttribute("userData", userFromDB );
					
					if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_ADMIN)) {
						return "adminDashboardPage";
					} else if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_USER)) {
						return "userDashboardPage";
					}
				}

			}
			return "index";
		}

		return "index";

	}

}
