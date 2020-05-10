package com.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.config.JwtTokenUtil;
import com.online.entities.Users;
import com.online.model.JwtRequest;
import com.online.model.JwtResponse;
import com.online.service.AuthenticationService;

@CrossOrigin
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	JwtResponse response;
	
	@PostMapping("/register")
	public JwtResponse registerUser(@RequestBody Users user) throws Exception{
		
		String registedUserMsg = authService.registerUserDetails(user);
		response.setJwttoken(null);
		response.setMessage(registedUserMsg);
		return response;
	}
	
	@PostMapping("/login")
	public JwtResponse authenticateUser(@RequestBody JwtRequest user) throws Exception{
		
		Boolean authenticate = authenticate(user.getUsername(),user.getPassword());
		if(authenticate) {
			UserDetails userDetails = authService.loadUserByUsername(user.getUsername());
			String generateToken = jwtTokenUtil.generateToken(userDetails);
			System.out.println("Token: "+ generateToken);
			response.setJwttoken(generateToken);
			response.setMessage("Authenticated successfully");
		}else {
			response.setJwttoken(null);
			response.setMessage("Not a valid user");
		}

		return response;
		
	}

	private Boolean authenticate(String username, String password) throws Exception {
		try {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
				Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
				SecurityContextHolder.getContext().setAuthentication(authenticate);
				System.out.println("Security: "+SecurityContextHolder.getContext().getAuthentication());
				return true;
			
		} catch(InternalAuthenticationServiceException iase) {
			System.out.println("INVALID_CREDENTIALS"+ iase);
			return false;
		}
		
		catch (DisabledException e) {
			System.out.println("USER_DISABLED"+ e);
			return false;
		} catch (BadCredentialsException e) {
			System.out.println("INVALID_CREDENTIALS"+ e);
			return false;
		}
	}
}
