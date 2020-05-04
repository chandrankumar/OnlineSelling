package com.online.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles", schema = "veggi")
public class UsersRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private int user_role_id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;

	@Column(name = "authority")
	private String role;

	/**
	 * @return the user_role_id
	 */
	public int getUser_role_id() {
		return user_role_id;
	}

	/**
	 * @param user_role_id the user_role_id to set
	 */
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
