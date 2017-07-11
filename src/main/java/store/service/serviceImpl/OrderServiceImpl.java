package store.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.persistence.entity.Order;
import store.persistence.repository.OrderDao;
import store.service.OrderServise;

@Service
public class OrderServiceImpl implements OrderServise{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order save(Order entity) {
		orderDao.save(entity);
		return entity;
	}

	@Override
	public Order update(Order entity) {
		return orderDao.update(entity);
	}

	@Override
	public void delete(Order entity) {
		orderDao.delete(entity);
	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}

}
