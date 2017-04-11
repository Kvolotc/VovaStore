package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Brake;
import store.persistence.repository.BrakeDao;
import store.service.BrakeService;

@Service
public class BrakeServiceImpl implements BrakeService {

	@Autowired
	private BrakeDao brakeDao;
	
	@Override
	public void save(Brake entity) {
		brakeDao.save(entity);
	}

	@Override
	public Brake update(Brake entity) {
		return brakeDao.update(entity);
	}

	@Override
	public void delete(Brake entity) {
		brakeDao.delete(entity);
	}

	@Override
	public Brake findById(Integer id) {
		return brakeDao.findById(id);
	}

	@Override
	public List<Brake> findAll() {
		return brakeDao.findAll();
	}

	@Override
	public List<Brake> sortProductByToMinPrice() {
		return brakeDao.sortProductByToMinPrice();
	}

	@Override
	public List<Brake> sortProductByToMaxPrice() {
		return brakeDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Brake> findBetweenPrice(Integer min, Integer max) {
		return brakeDao.findBetweenPrice(min, max);
	}

}
