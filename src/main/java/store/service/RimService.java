package store.service;

import java.util.List;

import store.persistence.entity.Rim;

public interface RimService extends GenericProductService<Rim, Integer> {

	public List<Rim> findbyDiameter(Integer diameter);
}
