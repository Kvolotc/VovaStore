package store.service;

import java.util.List;

import store.persistence.entity.Fork;

public interface ForkService extends GenericProductService<Fork, Integer>{
	
    public List<Fork> findByCourse(Integer course);
	
	public List<Fork> findBetweenCourse(Integer min, Integer max);
	
	
}
