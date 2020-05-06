package com.online.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.online.dao.AuthenticationDao;
import com.online.entities.Users;
import com.online.entities.UsersRoles;

@Service
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService{

	@Autowired
	AuthenticationDao authDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		
		return authDao.findByUsername(username);
	}

	@Override
	@Transactional
	public String registerUserDetails(Users user) {
		UsersRoles usersRole = new UsersRoles();
		usersRole.setRole("ROLE_USER");
		usersRole.setUsers(user);
		user.setUsersRole(usersRole);
		return authDao.registerUser(user);
	}

}
