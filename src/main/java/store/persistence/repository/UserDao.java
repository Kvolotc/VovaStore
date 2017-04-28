package store.persistence.repository;

import java.util.List;

import store.persistence.entity.User;

public interface UserDao extends GenericDao<User,Integer > {
	
	public User findByEmail(String email);
	
	public User findByToken(String token);
	
	public List<User> indNotActiveUsers();
	

}
