package com.online.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.online.entities.Users;

public interface AuthenticationService{
	
	public UserDetails loadUserByUsername(String username);

	public String registerUserDetails(Users user);
	
}
