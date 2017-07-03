package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Frame;
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
	
	@Override
	public int findAmountPages() {
		return rimDao.findAmountPages();
	}

	@Override
	public List<Rim> findProducts(int page) {
		return rimDao.findProducts(page);
	}

	@Override
	public List<Rim> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page) {
		return rimDao.findBySearchProductsWithOneSearchWord(searchWord, min, max, page);
	}

	@Override
	public List<Rim> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max,
			int page) {
		return rimDao.findBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max, page);
	}

	@Override
	public int findAmountBySearchProductsWithOneSearchWord(String searchWord, int min, int max) {
		return rimDao.findAmountBySearchProductsWithOneSearchWord(searchWord, min, max);
	}

	@Override
	public int findAmountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {
		return rimDao.findAmountBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max);
	}

	@Override
	public int findMaxPriceProduct() {
		return rimDao.findMaxPriceProduct();
	}

}
