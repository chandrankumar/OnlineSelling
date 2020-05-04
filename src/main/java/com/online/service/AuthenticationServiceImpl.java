package com.online.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.online.dao.AuthenticationDao;
import com.online.entities.Users;

@Service
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService{

	@Autowired
	AuthenticationDao authDao;
	
	@Override
	@Transactional
	public Users saveUser(Users user) {
		return authDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		
		return authDao.findByUsername(username);
	}

}
