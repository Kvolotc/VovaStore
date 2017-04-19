package store.service;


import java.util.List;

import store.persistence.entity.Bike;

public interface BikeService extends GenericProductService<Bike, Integer> {
	
	public List<Bike> findMountainBikes();
	
	public List<Bike> findAllMountainBikes();
	
	public List<Bike> findRacingBikes();
	
}
