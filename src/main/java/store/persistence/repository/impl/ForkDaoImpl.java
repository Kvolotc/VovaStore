package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Fork;
import store.persistence.repository.ForkDao;

@Repository
public class ForkDaoImpl extends GenericProductDaoImpl<Fork, Integer> implements ForkDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	protected ForkDaoImpl() {
		super(Fork.class);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Fork> findByCourse(Integer course) {
		return entityManager.createQuery("FROM Fork f WHERE f.course = "+course, Fork.class).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Fork> findBetweenCourse(Integer min, Integer max) {
		return entityManager.createQuery("FROM FORK e BETWEEN"+min+"AND"+max, Fork.class).getResultList();
	}

}
