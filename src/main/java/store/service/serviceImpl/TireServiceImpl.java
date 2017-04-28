package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Rim;
import store.persistence.entity.Tire;
import store.persistence.repository.TireDao;
import store.service.TireService;

@Service
public class TireServiceImpl implements TireService {

	@Autowired
	private TireDao tireDao;
	
	@Override
	public  Tire save(Tire entity) {
		tireDao.save(entity);
		
		return entity;
	}

	@Override
	public Tire update(Tire entity) {
		return tireDao.update(entity);
	}

	@Override
	public void delete(Tire entity) {
		tireDao.delete(entity);
	}

	@Override
	public Tire findById(Integer id) {
		return tireDao.findById(id);
	}

	@Override
	public List<Tire> findAll() {
		return tireDao.findAll();
	}

	@Override
	public List<Tire> sortProductByToMinPrice() {
		return tireDao.sortProductByToMinPrice();
	}

	@Override
	public List<Tire> sortProductByToMaxPrice() {
		return tireDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Tire> findBetweenPrice(Integer min, Integer max) {
		return tireDao.findBetweenPrice(min, max);
	}
	
	@Override
	public List<Tire> findbyDiameter(Integer diameter) {
		return tireDao.findbyDiameter(diameter);
	}
	
	@Override
	public int findCountPages() {
		return tireDao.findCountPages();
	}

	@Override
	public List<Tire> findProducts(int page) {
		return tireDao.findProducts(page);
	}

}
