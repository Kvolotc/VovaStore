package store.service;

import java.util.List;

import store.persistence.entity.Frame;

public interface FrameService extends GenericProductService<Frame, Integer> {
	
	public List<Frame> findBySize(String size);
	
	public List<Frame> findWithSnubber();
	
	public List<Frame> findWithOutSnubber();

}
