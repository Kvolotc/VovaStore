package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Bike;

public interface BikeDao extends GenericProductDao<Bike,Integer> {

	public List<Bike> findMountainBikes();
	
	public List<Bike> findAllMountainBikes();
	
	public List<Bike> findRacingBikes();
	
}
