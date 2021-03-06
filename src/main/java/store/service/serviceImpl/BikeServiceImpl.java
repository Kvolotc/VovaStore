package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import store.persistence.entity.Bike;
import store.persistence.repository.BikeDao;
import store.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService{

	@Autowired
	private BikeDao bikeDao;
	
	@Override
	public Bike save(Bike entity) {
		bikeDao.save(entity);	
		return entity;
	}

	@Override
	public Bike update(Bike entity) {
		return bikeDao.update(entity);
	}

	@Override
	public void delete(Bike entity) {
		bikeDao.delete(entity);
	}

	@Override
	public Bike findById(Integer id) {
		return bikeDao.findById(id);
	}

	@Override
	public List<Bike> findAll() {
		return bikeDao.findAll();
	}

	@Override
	public List<Bike> sortProductByToMinPrice() {
		return bikeDao.sortProductByToMinPrice();
	}

	@Override
	public List<Bike> sortProductByToMaxPrice() {
		return bikeDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Bike> findBetweenPrice(Integer min, Integer max) {
		return bikeDao.findBetweenPrice(min, max);
	}

	@Override
	public List<Bike> findMountainBikes(int page) {		
		return bikeDao.findMountainBikes(page);
	}

	@Override
	public List<Bike> findAllMountainBikes(int page) {
		return bikeDao.findAllMountainBikes(page);
	}

	@Override
	public List<Bike> findRacingBikes(int page) {	
		return bikeDao.findRacingBikes(page);
	}

	@Override
	public int findAmountPageMountainBikes() {
		return bikeDao.findAmountPageMountainBikes();
	}

	@Override
	public int findAmountPageAllMountainBikes() {
		return bikeDao.findAmountPageAllMountainBikes();
	}

	@Override
	public int findAmountPageRacingBikes() {
		return bikeDao.findAmountPageRacingBikes();
	}

	@Override
	public List<Bike> findBySearchBikesWithOneSearchWord(String SearchWord, int min, int max, int page) {		
		return bikeDao.findBySearchBikesWithOneSearchWord(SearchWord, min, max, page);
	}

	@Override
	public List<Bike> findBySearchBikesWithTwoSearchWords(String SearchWord, String SearchWord2, int min, int max, int page) {
		return bikeDao.findBySearchBikesWithTwoSearchWords(SearchWord, SearchWord2, min, max, page);
	}

	@Override
	public int findAmountBySearchBikesWithOneSearchWord(String SearchWord, int min, int max) {
		return bikeDao.findAmountBySearchBikesWithOneSearchWord(SearchWord, min, max);
	}

	@Override
	public int findAmountBySearchBikesWithTwoSearchWords(String SearchWord, String SearchWord2, int min, int max) {
		return bikeDao.findAmountBySearchBikesWithTwoSearchWords(SearchWord, SearchWord2, min, max);
	}

	@Override
	public int findMaxPrice() {
		return bikeDao.findMaxPrice();
	}

	@Override
	public Bike findByImageName(String imageName) {
		return bikeDao.findByImageName(imageName);
	}

	@Override
	public int findAmountAllBikes() {
		return bikeDao.findAmountAllBikes();
	}

	@Override
	public List<Bike> findAllBikesbyPage(int page) {
		return bikeDao.findAllBikesbyPage(page);
	}
	
}
