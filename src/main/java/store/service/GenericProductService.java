package store.service;

import java.util.List;

public interface GenericProductService<T,ID> extends GenericService<T, ID> {
	
    public List<T> sortProductByToMinPrice();
	
	public List<T> sortProductByToMaxPrice();
	
	public List<T> findBetweenPrice(Integer min , Integer max);

}
