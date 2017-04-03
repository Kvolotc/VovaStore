package store.service;

import java.util.List;

import store.persistence.entity.Tire;

public interface TireService extends GenericProductService<Tire, Integer> {

	public List<Tire> findbyDiameter(Integer diameter);
}
