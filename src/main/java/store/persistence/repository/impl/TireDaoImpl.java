package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Tire;
import store.persistence.repository.TireDao;

@Repository
public class TireDaoImpl extends GenericProductDaoImpl<Tire, Integer> implements TireDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final static int SIZE_PAGE = 1;
	
	protected TireDaoImpl() {
		super(Tire.class);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Tire> findbyDiameter(Integer diameter) {
		return entityManager.createQuery("FROM Tire t WHERE t.diameter = :diameter",Tire.class)
				.setParameter("diameter", diameter).getResultList();
	}

}
