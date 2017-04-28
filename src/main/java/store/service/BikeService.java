package store.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import store.persistence.entity.Bike;

public interface BikeService extends GenericService<Bike, Integer> {
	
	public List<Bike> findMountainBikes(int page);
	
	public List<Bike> findAllMountainBikes(int page);
	
	public List<Bike> findRacingBikes(int page);
	
	public int findCountPageMountainBikes();
	
	public int findCountPageAllMountainBikes();
	
	public int findCountPageRacingBikes();	

	public List<Bike> sortProductByToMinPrice();
	
	public List<Bike> sortProductByToMaxPrice();
	
	public List<Bike> findBetweenPrice(Integer min , Integer max);
	
}
