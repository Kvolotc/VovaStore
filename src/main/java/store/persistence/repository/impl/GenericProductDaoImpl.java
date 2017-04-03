package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.repository.GenericProductDao;


@Repository
public abstract class GenericProductDaoImpl<T, ID> extends GenericDaoImpl<T, ID> implements GenericProductDao<T, ID>  {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> entity;

	protected GenericProductDaoImpl(Class<T> entity) {
		super(entity);
		this.entity = entity;		
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> sortProductByToMaxPrice() {
		return entityManager.createQuery("FROM"+entity.getSimpleName()+"e ORDER BY e.price DESC",entity).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> sortProductByToMinPrice() {
		return entityManager.createQuery("FROM"+entity.getSimpleName()+"e ORDER BY e.price ASC",entity).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findBetweenPrice(Integer min, Integer max) {
		return entityManager.createQuery("FROM"+entity.getSimpleName()+"e BETWEEN"+min+"AND"+max,entity).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findByType(String type) {
		return entityManager.createQuery("FROM"+entity.getSimpleName()+"e WHERE f.type = "+type,entity).getResultList();
	}

}
