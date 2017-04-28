package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Rim;
import store.persistence.repository.RimDao;

@Repository
public class RimDaoImpl extends GenericProductDaoImpl<Rim, Integer> implements RimDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final static int SIZE_PAGE = 1;
	
	protected RimDaoImpl() {
		super(Rim.class);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Rim> findbyDiameter(Integer diameter) {
		return entityManager.createQuery("FROM Rim r WHERE r.diameter = :diameter",Rim.class)
				.setParameter("diameter", diameter).getResultList();
	}

}
