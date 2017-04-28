package store.service.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import store.persistence.entity.User;
import store.persistence.repository.UserDao;
import store.service.UserService;

@Service
public class UserServiceImpl implements  UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User save(User entity) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			
		userDao.save(entity);
		
		return entity;
	
	}

	@Override
	public User update(User entity) {
		return userDao.update(entity);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	@Override
	public User findByToken(String token) {
		
		return userDao.findByToken(token);
	}

	@Override
	public List<User> findNotActiveUsers() {
		return userDao.indNotActiveUsers();
	}

}
