package store.persistence.repository;

import java.util.List;


public interface GenericProductDao<T, ID> extends GenericDao<T, ID> {

	public List<T> sortProductByToMinPrice();
	
	public List<T> sortProductByToMaxPrice();
	
	public List<T> findBetweenPrice(Integer min , Integer max);
	
    public int findCountPages();
	
	public List<T> findProducts(int page);
	
	
}
