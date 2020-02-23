package com.booking.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	String signIn(AuthenticationRequest request, HttpServletResponse resp, HttpSession httpSession) {

		User userFromDB = userService.findUserByEmailOrMobileNoOrUserName(request.getLoginCredentials());

		System.out.println("userFromDB -> " + userFromDB);
		if (userFromDB != null && !request.getPassword().equals(userFromDB.getPassword())) {
			return "signInPage";
		}

		Cookie userNameCookie = new Cookie("user", request.getLoginCredentials());
		userNameCookie.setMaxAge(24 * 60 * 60);
		resp.addCookie(userNameCookie);

		// beforing adding password into cookie hash the paswword
		Cookie passwordCookie = new Cookie("password", request.getPassword());
		passwordCookie.setMaxAge(24 * 60 * 60);
		resp.addCookie(passwordCookie);

		httpSession.setAttribute("userData", userFromDB);

		// logic for Authorization
		if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_ADMIN)) {
			return "adminDashboardPage";
		} else if (userFromDB != null && userFromDB.getRole().equals(Constants.ROLE_USER)) {
			return "userDashboardPage";
		}
		return "signInPage";
	}

	@RequestMapping("/logoutPage")
	public String logoutPage() {
		return "logoutPage";
	}

	@RequestMapping("/logout/{value}")
	public String logout(@PathVariable String value, HttpServletRequest request, HttpServletResponse resp,
			HttpSession httpSession) {

		if ("yes".equalsIgnoreCase(value)) {
			System.out.println("----------------into logoyt yes---------------");
			// delete httpSession Object
			httpSession.removeAttribute("userData");

			// delete cookies
			Cookie userNameCookie = new Cookie("user","");
			userNameCookie.setMaxAge(0);
			userNameCookie.setPath("/TrainBooking");
			resp.addCookie(userNameCookie);
			Cookie passwordCookie = new Cookie("password", "");
			passwordCookie.setPath("/TrainBooking");
			passwordCookie.setMaxAge(0);
			resp.addCookie(passwordCookie);
			
			
			
//			Cookie[] cookies = request.getCookies();
//			if (cookies != null) {
//				for (Cookie cookie : cookies) {
//					if (cookie.getName().equals("user")) {
//						cookie.setValue("");
//					} else if (cookie.getName().equals("password")) {
//						cookie.setValue("");
//						cookie.setMaxAge(0);
//						resp.addCookie(cookie);
//					}
//					cookie.setMaxAge(0);
//					cookie.setPath("/TrainBooking");
//					
//					resp.addCookie(cookie);
//
//				}
//			}
		}

		else {
			return "redirect: /TrainBooking";
		}

		return "redirect: /TrainBooking";
	}

}
