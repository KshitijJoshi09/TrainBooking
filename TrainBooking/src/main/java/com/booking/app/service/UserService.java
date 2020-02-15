package com.booking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.app.dto.User;
import com.booking.app.respository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findUserByEmailOrMobileNoOrUserName(String loginData) {
		User user = userRepository.findUserByEmailOrMobileNoOrUserName(loginData);
		return user;
	}

	
	
	
	
	
	
	
	
	
}
