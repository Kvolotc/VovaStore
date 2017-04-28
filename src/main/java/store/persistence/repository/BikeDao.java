package store.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import store.persistence.entity.Bike;

public interface BikeDao extends GenericDao<Bike, Integer>  {
	
	public List<Bike> sortProductByToMinPrice();
	
	public List<Bike> sortProductByToMaxPrice();
	
	public List<Bike> findBetweenPrice(Integer min , Integer max);
	
	public List<Bike> findMountainBikes(int page);
	
	public List<Bike> findAllMountainBikes(int page);
	
	public List<Bike> findRacingBikes(int page);
	
	public int findCountPageMountainBikes();
	
	public int findCountPageAllMountainBikes();
	
	public int findCountPageRacingBikes();
	
}
