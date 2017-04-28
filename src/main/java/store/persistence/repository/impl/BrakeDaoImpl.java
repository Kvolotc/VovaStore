package store.persistence.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Bike;
import store.persistence.entity.Brake;
import store.persistence.repository.BrakeDao;

@Repository
public class BrakeDaoImpl extends GenericProductDaoImpl<Brake, Integer> implements BrakeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final static int SIZE_PAGE = 1;
	
	protected BrakeDaoImpl() {
		super(Brake.class);
		
	}

}
