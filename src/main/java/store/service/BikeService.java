package store.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import store.persistence.entity.Bike;

public interface BikeService extends GenericService<Bike, Integer> {
	
	public List<Bike> findMountainBikes(int page);
	
	public List<Bike> findAllMountainBikes(int page);
	
	public List<Bike> findRacingBikes(int page);
	
	public int findAmountPageMountainBikes();
	
	public int findAmountPageAllMountainBikes();
	
	public int findAmountPageRacingBikes();
	
	public int findAmountAllBikes();

	public List<Bike> sortProductByToMinPrice();
	
	public List<Bike> sortProductByToMaxPrice();
	
	public List<Bike> findBetweenPrice(Integer min , Integer max);
	
	public List<Bike> findBySearchBikesWithOneSearchWord(String searchWord, int min, int max, int page);
	
	public List<Bike> findBySearchBikesWithTwoSearchWords(String searchWord, String searchWord2, int min, int max, int page);
	
	public int findAmountBySearchBikesWithOneSearchWord(String searchWord, int min, int max);
	
	public int findAmountBySearchBikesWithTwoSearchWords(String searchWord, String searchWord2, int min, int max);
	
	public int findMaxPrice();
	
	public Bike findByImageName(String imageName);
	
	public List<Bike> findAllBikesbyPage(int page);

}
