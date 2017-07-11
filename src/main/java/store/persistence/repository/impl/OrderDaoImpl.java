package store.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import store.persistence.entity.Order;
import store.persistence.repository.OrderDao;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao {

	protected OrderDaoImpl() {
		super(Order.class);
	}

}
