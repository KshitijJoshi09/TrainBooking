package com.booking.app.util;

public class AuthenticationRequest {
	
	private String loginCredentials;
	private String password;
	
	public String getLoginCredentials() {
		return loginCredentials;
	}
	public void setLoginCredentials(String loginCredentials) {
		this.loginCredentials = loginCredentials;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthenticationRequest [loginCredentials=" + loginCredentials + ", password=" + password + "]";
	}
	
	
	
	
	
}
