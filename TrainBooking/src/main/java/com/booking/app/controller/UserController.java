package com.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.app.config.Constants;
import com.booking.app.dto.User;
import com.booking.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/displaySignUpPage")
	public String displayUserSignPage() {
		return "signUpPage";
	}

	@RequestMapping(value = "/signUp" , method = RequestMethod.POST)
	public String userSignPage(User user, Model model) {
		
		
		//add role s user
		user.setRole(Constants.ROLE_USER);
		
		int pk = userService.addUser(user);
		if (pk > 0) {
			return "signInPage";
		}
		model.addAttribute("msg", "sign failed");
		return "signUpPage";
	}

}
