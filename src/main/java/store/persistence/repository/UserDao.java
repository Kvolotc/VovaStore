package store.persistence.repository;

import store.persistence.entity.User;

public interface UserDao extends GenericDao<User,Integer > {
	
	User findByEmail(String email);

}
