package store.persistence.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Bike;
import store.persistence.entity.User;
import store.persistence.repository.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	private final static int SIZE_PAGE = 25;

	public UserDaoImpl() {
		super(User.class);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public User findByEmail(String email) {

		return (User) entityManager.createNativeQuery("SELECT * FROM users WHERE email = :email", User.class)

				.setParameter("email", email).getSingleResult();

	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public User findByToken(String token) {

		return (User) entityManager.createNativeQuery("SELECT * FROM users WHERE password = :token", User.class)
				.setParameter("token", token).getSingleResult();
	}

	@Override
	public List<User> indNotActiveUsers() {

		return entityManager.createNativeQuery("SELECT * FROM users WHERE is_activated  = false ", User.class)
				.getResultList();
	}

	@Override
	public List<User> findUserByPage(int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager.createNativeQuery("SELECT * FROM users", User.class).setFirstResult(from)
				.setMaxResults(SIZE_PAGE).getResultList();
	}

	@Override
	public int findAmountPageUsers() {

		BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT COUNT(*) FROM users").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

}
