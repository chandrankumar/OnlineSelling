package com.online.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> password;
	public static volatile SingularAttribute<Users, UsersRoles> usersRole;
	public static volatile SingularAttribute<Users, Integer> id;
	public static volatile SingularAttribute<Users, String> username;

	public static final String PASSWORD = "password";
	public static final String USERS_ROLE = "usersRole";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

