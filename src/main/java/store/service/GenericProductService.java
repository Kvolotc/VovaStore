package store.service;

import java.util.List;

import store.persistence.entity.Brake;

public interface GenericProductService<T,ID> extends GenericService<T, ID> {
	
    public List<T> sortProductByToMinPrice();
	
	public List<T> sortProductByToMaxPrice();
	
	public List<T> findBetweenPrice(Integer min , Integer max);
	
    public int findCountPages();
	
	public List<T> findProducts(int page);
	
    public List<T> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page);
	
	public List<T> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max, int page);
	
	public int findCountBySearchProductsWithOneSearchWord(String searchWord, int min, int max);
	
	public int findCountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max);

	public int findMaxPriceProduct();
}
