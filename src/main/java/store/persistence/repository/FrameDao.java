package store.persistence.repository;

import java.util.List;

import store.persistence.entity.Frame;

public interface FrameDao extends GenericProductDao<Frame,Integer> {

	public List<Frame> findBySize(String size);
	
	public List<Frame> findWithSnubber();
	
	public List<Frame> findWithOutSnubber();
	
}
