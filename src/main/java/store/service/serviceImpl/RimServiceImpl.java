package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Rim;
import store.persistence.repository.RimDao;
import store.service.RimService;

@Service
public class RimServiceImpl implements RimService {

	@Autowired
	private RimDao rimDao;
	
	@Override
	public Rim save(Rim entity) {
		rimDao.save(entity);
		
		return entity;
	}

	@Override
	public Rim update(Rim entity) {
		return rimDao.update(entity);
	}

	@Override
	public void delete(Rim entity) {
		rimDao.delete(entity);
	}

	@Override
	public Rim findById(Integer id) {
		return rimDao.findById(id);
	}

	@Override
	public List<Rim> findAll() {
		return rimDao.findAll();
	}

	@Override
	public List<Rim> sortProductByToMinPrice() {
		return rimDao.sortProductByToMinPrice();
	}

	@Override
	public List<Rim> sortProductByToMaxPrice() {
		return rimDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Rim> findBetweenPrice(Integer min, Integer max) {
		return rimDao.findBetweenPrice(min, max);
	}

	@Override
	public List<Rim> findbyDiameter(Integer diameter) {
		return rimDao.findbyDiameter(diameter);
	}

}
