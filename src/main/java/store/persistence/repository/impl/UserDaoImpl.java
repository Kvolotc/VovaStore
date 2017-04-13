package store.persistence.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.User;
import store.persistence.repository.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserDaoImpl() {
		super(User.class);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public User findByEmail(String email) {
		
		return (User) entityManager.createNativeQuery("SELECT * from users where email = :email", User.class)
		
		.setParameter("email", email).getSingleResult();
		

		
	}

}
