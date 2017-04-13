package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Frame;
import store.persistence.repository.FrameDao;
import store.service.FrameService;

@Service
public class FrameServiceImpl implements FrameService {

	@Autowired
	private FrameDao frameDao;
	
	@Override
	public void save(Frame entity) {
		frameDao.save(entity);
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

}
