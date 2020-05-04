package com.online.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.online.entities.Users;

public interface AuthenticationDao{

	public UserDetails findByUsername(String username);
	
	public Users save(Users user);
}
