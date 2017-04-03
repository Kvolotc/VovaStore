package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Tire;

public interface TireDao extends GenericProductDao<Tire, Integer> {

	public List<Tire> findbyDiameter(Integer diameter);
}
