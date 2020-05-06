package com.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
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
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Users user) throws Exception{
		
		String response = authService.registerUserDetails(user);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest user) throws Exception{
		
		authenticate(user.getUsername(),user.getPassword());
		UserDetails userDetails = authService.loadUserByUsername(user.getUsername());
		String generateToken = jwtTokenUtil.generateToken(userDetails);
		System.out.println("Token: "+ generateToken);
		return ResponseEntity.ok(new JwtResponse(generateToken));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			System.out.println("Security: "+SecurityContextHolder.getContext().getAuthentication());
		} catch (DisabledException e) {
			System.out.println("USER_DISABLED"+ e);
		} catch (BadCredentialsException e) {
			System.out.println("INVALID_CREDENTIALS"+ e);
		}
	}
}
