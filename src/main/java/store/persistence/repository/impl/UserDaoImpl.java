package store.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import store.persistence.entity.User;
import store.persistence.repository.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
