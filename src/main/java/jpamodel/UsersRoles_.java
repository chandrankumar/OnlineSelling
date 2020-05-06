package jpamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.online.entities.Users;
import com.online.entities.UsersRoles;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsersRoles.class)
public abstract class UsersRoles_ {

	public static volatile SingularAttribute<UsersRoles, Integer> user_role_id;
	public static volatile SingularAttribute<UsersRoles, String> role;
	public static volatile SingularAttribute<UsersRoles, Users> users;

	public static final String USER_ROLE_ID = "userRoleId";
	public static final String ROLE = "role";
	public static final String USERS = "users";

}

