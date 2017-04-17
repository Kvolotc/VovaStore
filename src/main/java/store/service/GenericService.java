package store.service;

import java.util.List;

public interface GenericService<T,ID> {
	
    public T save(T entity);
	
	public T update(T entity);
	
	public void delete(T entity);
	
	public T findById(ID id);
	
	public List<T> findAll();

}
