package store.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import store.persistence.entity.Brake;
import store.persistence.repository.BrakeDao;

@Repository
public class BrakeDaoImpl extends GenericProductDaoImpl<Brake, Integer> implements BrakeDao {

	protected BrakeDaoImpl() {
		super(Brake.class);
		
	}

}
