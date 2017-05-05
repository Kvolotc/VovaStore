package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Fork;
import store.persistence.entity.Frame;
import store.persistence.repository.FrameDao;
import store.service.FrameService;

@Service
public class FrameServiceImpl implements FrameService {

	@Autowired
	private FrameDao frameDao;
	
	@Override
	public Frame save(Frame entity) {
		frameDao.save(entity);
		
		return entity;
	}

	@Override
	public Frame update(Frame entity) {
		return frameDao.update(entity);
	}

	@Override
	public void delete(Frame entity) {
		frameDao.delete(entity);
	}

	@Override
	public Frame findById(Integer id) {
		return frameDao.findById(id);
	}

	@Override
	public List<Frame> findAll() {
		return frameDao.findAll();
	}

	@Override
	public List<Frame> sortProductByToMinPrice() {
		return frameDao.sortProductByToMinPrice();
	}

	@Override
	public List<Frame> sortProductByToMaxPrice() {
		return frameDao.sortProductByToMaxPrice();
	}

	@Override
	public List<Frame> findBetweenPrice(Integer min, Integer max) {
		return frameDao.findBetweenPrice(min, max);
	}
	
	@Override
	public List<Frame> findBySize(String size) {
		return frameDao.findBySize(size);
	}
	
	@Override
	public List<Frame> findWithSnubber() {
		return frameDao.findWithSnubber();
	}
	
	@Override
	public List<Frame> findWithOutSnubber() {
		return frameDao.findWithOutSnubber();
	}

	@Override
	public int findCountPages() {
		return frameDao.findCountPages();
	}

	@Override
	public List<Frame> findProducts(int page) {
		return frameDao.findProducts(page);
	}

	@Override
	public List<Frame> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page) {
		return frameDao.findBySearchProductsWithOneSearchWord(searchWord, min, max, page);
	}

	@Override
	public List<Frame> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max,
			int page) {
		return frameDao.findBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max, page);
	}

	@Override
	public int findCountBySearchProductsWithOneSearchWord(String searchWord, int min, int max) {
		return frameDao.findCountBySearchProductsWithOneSearchWord(searchWord, min, max);
	}

	@Override
	public int findCountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {
		return frameDao.findCountBySearchProductsWithTwoSearchWords(searchWord, searchWord2, min, max);
	}
}
