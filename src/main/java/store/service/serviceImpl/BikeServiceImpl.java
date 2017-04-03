package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Bike;
import store.persistence.repository.BikeDao;
import store.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService{

	@Autowired
	private BikeDao bikeDao;
	
	@Override
	public void save(Bike entity) {
		bikeDao.save(entity);
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
	public List<Bike> findByType(String type) {
		return bikeDao.findByType(type);
	}

}
