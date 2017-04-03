package store.persistence.repository;

import java.util.List;


public interface GenericDao<T, ID> {
	
    public void save(T entity);
	
	public T update(T entity);
	
	public void delete(T entity);
	
	public T findById(ID id);
	
	public List<T> findAll();

}
