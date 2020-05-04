package com.online.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.online.entities.Users;

public interface AuthenticationService{
	
	public Users saveUser(Users user);

	public UserDetails loadUserByUsername(String username);
	
}
