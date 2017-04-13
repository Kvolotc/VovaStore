package store.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Frame;
import store.persistence.repository.FrameDao;

@Repository
public class FrameDaoImpl extends GenericProductDaoImpl<Frame, Integer> implements FrameDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected FrameDaoImpl() {
		super(Frame.class);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Frame> findBySize(String size) {

		return entityManager.createQuery("FROM Frame f WHERE f.size = :size",Frame.class)
				.setParameter("size", size).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Frame> findWithSnubber() {
		return entityManager.createQuery("FROM Frame f WHERE f.isExistSnubber = 1",Frame.class).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Frame> findWithOutSnubber() {	
		return entityManager.createQuery("FROM Frame f WHERE f.isExistSnubber = 0",Frame.class).getResultList();
	}
}
