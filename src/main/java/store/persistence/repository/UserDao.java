package store.persistence.repository;

import store.persistence.entity.User;

public interface UserDao extends GenericDao<User,Integer > {
	
	public User findByEmail(String email);
	public User findByToken(String token);
	

}
