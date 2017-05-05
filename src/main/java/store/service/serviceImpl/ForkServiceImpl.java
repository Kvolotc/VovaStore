package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Brake;
import store.persistence.entity.Fork;
import store.persistence.repository.ForkDao;
import store.service.ForkService;

@Service
public class ForkServiceImpl implements ForkService{

	@Autowired
	private ForkDao forkDao;
	
	@Override
	public Fork save(Fork entity) {
		forkDao.save(entity);
		
		return entity;
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
	
	@Override
    public List<Fork> findByCourse(Integer course) {
		return forkDao.findByCourse(course);	   
		
    }
	@Override
	public List<Fork> findBetweenCourse(Integer min, Integer max) {
		return forkDao.findBetweenCourse(min, max);	
	}
	
	@Override
	public int findCountPages() {
		return forkDao.findCountPages();
	}

	@Override
	public List<Fork> findProducts(int page) {
		return forkDao.findProducts(page);
	}

	@Override
	public List<Fork> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page) {
		return forkDao.findBySearchProductsWithOneSearchWord(searchWord, min, max, page);
	}

	@Override
	public List<Fork> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max,
			int page) {
		return forkDao.findBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max, page);
	}

	@Override
	public int findCountBySearchProductsWithOneSearchWord(String searchWord, int min, int max) {
		return forkDao.findCountBySearchProductsWithOneSearchWord(searchWord, min, max);
	}

	@Override
	public int findCountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {
		return forkDao.findCountBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max);
	}
	
}
