package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Fork;
import store.persistence.repository.ForkDao;
import store.service.ForkService;

@Service
public class ForkServiceImpl implements ForkService{

	@Autowired
	private ForkDao forkDao;
	
	@Override
	public void save(Fork entity) {
		forkDao.save(entity);
	}

	@Override
	public Fork update(Fork entity) {
		return forkDao.update(entity);
	}

	@Override
	public void delete(Fork entity) {
		forkDao.delete(entity);
	}

	@Override
	public Fork findById(Integer id) {
		return forkDao.findById(id);
	}

	@Override
	public List<Fork> findAll() {
		return forkDao.findAll();
	}

	@Override
	public List<Fork> sortProductByToMinPrice() {
		return forkDao.sortProductByToMinPrice();
	}

	@Override
	public List<Fork> sortProductByToMaxPrice() {
		return forkDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Fork> findBetweenPrice(Integer min, Integer max) {
		return forkDao.findBetweenCourse(min, max);
	}

    public List<Fork> findByCourse(Integer course) {
		return forkDao.findByCourse(course);	   
    }
	
	public List<Fork> findBetweenCourse(Integer min, Integer max) {
		return forkDao.findBetweenCourse(min, max);	
	}
	
}
