package store.persistence.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.entity.Bike;
import store.persistence.repository.BikeDao;

@Repository
public class BikeDaoImpl extends GenericDaoImpl<Bike, Integer> implements BikeDao {

	protected BikeDaoImpl() {
		super(Bike.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	private final static int SIZE_PAGE = 3;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> sortProductByToMinPrice() {
		return entityManager.createNativeQuery("SELECT * FROM bikes ORDER BY bikes.price ASC", Bike.class)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> sortProductByToMaxPrice() {
		return entityManager.createNativeQuery("SELECT * FROM bikes ORDER BY bikes.price DESC", Bike.class)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findBetweenPrice(Integer min, Integer max) {
		return entityManager
				.createNativeQuery("SELECT * FROM bikes WHERE bikes.price BETWEEN :min AND :max", Bike.class)
				.setParameter("min", min).setParameter("max", max).getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findMountainBikes(int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager
				.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE frames.type = 'MOUNTAIN' ", Bike.class)
				.setFirstResult(from).setMaxResults(SIZE_PAGE).getResultList();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findAllMountainBikes(int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager
				.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE frames.type = 'ALL_MOUNTAIN' ", Bike.class)
				.setFirstResult(from).setMaxResults(SIZE_PAGE).getResultList();

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Bike> findRacingBikes(int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager
				.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE frames.type = 'RACING' ", Bike.class)
				.setFirstResult(from).setMaxResults(SIZE_PAGE).getResultList();
	}

	@Override
	public int findCountPageMountainBikes() {

		BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT COUNT(*) FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'MOUNTAIN'").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Override
	public int findCountPageAllMountainBikes() {

		BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT COUNT(*) FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'ALL_MOUNTAIN'").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Override
	public int findCountPageRacingBikes() {
		BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT COUNT(*) FROM bikes JOIN frames ON"
				+ " bikes.frame_id = frames.id WHERE frames.type = 'RACING'").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Override
	public List<Bike> findBySearchBikesWithOneSearchWord(String searchWord, int min, int max, int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager
				.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE bikes.price BETWEEN :min and :max and frames.brand LIKE :searchWord"
						+ " or  bikes.price BETWEEN :min and :max and frames.model LIKE :searchWord", Bike.class)
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord+"%").setFirstResult(from)
				.setMaxResults(SIZE_PAGE).getResultList();
	}

	@Override
	public List<Bike> findBySearchBikesWithTwoSearchWords(String searchWord, String searchWord2, int min, int max, int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager
				.createNativeQuery("SELECT * FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE bikes.price BETWEEN :min and :max and frames.brand LIKE :searchWord and frames.model LIKE :searchWord2"
						+ " or  bikes.price BETWEEN :min and :max and frames.brand LIKE :searchWord2 and frames.model LIKE :searchWord", Bike.class)
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord+"%")
				.setParameter("searchWord2", searchWord2+"%").setFirstResult(from).setMaxResults(SIZE_PAGE).getResultList();
	}

	@Override
	public int findCountBySearchBikesWithOneSearchWord(String searchWord, int min, int max) {

		BigInteger bigInteger = (BigInteger) entityManager
				.createNativeQuery("SELECT COUNT(*) FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE bikes.price BETWEEN :min and :max and frames.brand LIKE :searchWord"
						+ " or  bikes.price BETWEEN :min and :max and frames.model LIKE :searchWord")
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord+"%").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Override
	public int findCountBySearchBikesWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {

		BigInteger bigInteger = (BigInteger) entityManager
				.createNativeQuery("SELECT COUNT(*) FROM bikes JOIN frames ON"
						+ " bikes.frame_id = frames.id WHERE bikes.price BETWEEN :min and :max and brand LIKE :searchWord and model LIKE :searchWord2"
						+ " or  bikes.price BETWEEN :min and :max and brand LIKE :searchWord2 and model LIKE :searchWord")
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord+"%")
				.setParameter("searchWord2", searchWord2+"%").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public int findMaxPrice() {
		return  (int) entityManager.createNativeQuery("SELECT MAX(bikes.price) FROM bikes").getSingleResult();
	}

}
