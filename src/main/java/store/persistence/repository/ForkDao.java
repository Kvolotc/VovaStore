package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Fork;

public interface ForkDao extends GenericProductDao<Fork, Integer>{

	public List<Fork> findByCourse(Integer course);
	
	public List<Fork> findBetweenCourse(Integer min, Integer max);
	
}
