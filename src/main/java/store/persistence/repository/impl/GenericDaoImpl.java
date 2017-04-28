package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.repository.GenericDao;

@Repository
public abstract class GenericDaoImpl <T, ID> implements GenericDao<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> entity;
	
	protected GenericDaoImpl(Class<T> entity) {
		this.entity = entity;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public T findById(ID id) {
		return entityManager.find(entity, id);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findAll() {
		return entityManager.createQuery("FROM "+entity.getSimpleName(),entity).getResultList();
	}

}
