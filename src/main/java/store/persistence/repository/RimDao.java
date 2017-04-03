package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Rim;

public interface RimDao extends GenericProductDao<Rim, Integer> {

	public List<Rim> findbyDiameter(Integer diameter);
}
