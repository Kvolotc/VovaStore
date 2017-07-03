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
	public Brake save(Brake entity) {
		brakeDao.save(entity);
		
		return entity;
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

	@Override
	public int findAmountPages() {
		return brakeDao.findAmountPages();
	}

	@Override
	public List<Brake> findProducts(int page) {
		return brakeDao.findProducts(page);
	}

	@Override
	public List<Brake> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page) {
		return brakeDao.findBySearchProductsWithOneSearchWord(searchWord, min, max, page);
	}

	@Override
	public List<Brake> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max,
			int page) {
		return brakeDao.findBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max, page);
	}

	@Override
	public int findAmountBySearchProductsWithOneSearchWord(String searchWord, int min, int max) {
		return brakeDao.findAmountBySearchProductsWithOneSearchWord(searchWord, min, max);
	}

	@Override
	public int findAmountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {
		return brakeDao.findAmountBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max);
	}

	@Override
	public int findMaxPriceProduct() {
		return brakeDao.findMaxPriceProduct();
	}
	
}
