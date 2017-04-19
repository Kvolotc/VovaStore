package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Bike;
import store.persistence.repository.BikeDao;

@Repository
public class BikeDaoImpl extends GenericProductDaoImpl<Bike, Integer> implements BikeDao  {

	@PersistenceContext
	private EntityManager entityManager;
	
	protected BikeDaoImpl() {
		super(Bike.class);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findMountainBikes() {
		
		return entityManager.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'MOUNTAIN' ",Bike.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findAllMountainBikes() {
		
		return entityManager.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'ALL_MOUNTAIN' ",Bike.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findRacingBikes() {
		
		return entityManager.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'RACING' ",Bike.class).getResultList();
	}


}
