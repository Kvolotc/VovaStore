package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Product;


public interface GenericProductDao<T, ID> extends GenericDao<T,ID> {

	public List<T> sortProductByToMinPrice();
	
	public List<T> sortProductByToMaxPrice();
	
	public List<T> findBetweenPrice(Integer min , Integer max);
	
	public List<T> findByType(String type);
	
}
