package com.online.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.online.entities.Users;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao{
	
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public UserDetails findByUsername(String username) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
		Root<Users> root = criteriaQuery.from(Users.class);
		criteriaQuery.select(root);		
		criteriaQuery.where(builder.equal(root.get("username"), username));
		TypedQuery<Users> query = manager.createQuery(criteriaQuery);
		Users singleResult  = query.getSingleResult();
		String role = singleResult.getUsersRole().getRole();
		System.out.print("usr: "+ singleResult.getUsername()+" pwd: "+" role: "+role);
		return new User(singleResult.getUsername(), singleResult.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(role)));
	}

	@Override
	@Transactional
	public Users save(Users user) {
		return manager.merge(user);
	}


}
