package store.service;

import store.persistence.entity.User;

public interface UserService extends GenericService<User, Integer> {
	
	public User findByEmail(String email);

}
