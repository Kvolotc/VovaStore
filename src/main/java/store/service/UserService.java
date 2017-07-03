package store.service;

import java.util.List;

import store.persistence.entity.User;

public interface UserService extends GenericService<User, Integer> {
	
	public User findByEmail(String email);
	
	public User findByToken(String token);
	
	public List<User> findNotActiveUsers();
	
	public List<User> findUserByPage(int page);
	
	public int findAmountPageUsers();

}
