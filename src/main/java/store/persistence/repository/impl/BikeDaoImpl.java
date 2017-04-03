package store.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import store.persistence.entity.Bike;
import store.persistence.repository.BikeDao;

@Repository
public class BikeDaoImpl extends GenericProductDaoImpl<Bike, Integer> implements BikeDao  {

	protected BikeDaoImpl() {
		super(Bike.class);
	}


}
