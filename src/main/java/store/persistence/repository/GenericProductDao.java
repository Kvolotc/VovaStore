package store.persistence.repository;

import java.util.List;


public interface GenericProductDao<T, ID> extends GenericDao<T, ID> {

	public List<T> sortProductByToMinPrice();
	
	public List<T> sortProductByToMaxPrice();
	
	public List<T> findBetweenPrice(Integer min , Integer max);
	
    public int findAmountPages();
	
	public List<T> findProducts(int page);
	
	public List<T> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page);
	
	public List<T> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max, int page);
	
	public int findAmountBySearchProductsWithOneSearchWord(String searchWord, int min, int max);
	
	public int findAmountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max);
	
	public int findMaxPriceProduct();

}
