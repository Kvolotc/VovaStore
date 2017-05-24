package store.persistence.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import store.persistence.repository.GenericProductDao;

@Repository
public abstract class GenericProductDaoImpl<T, ID> extends GenericDaoImpl<T, ID> implements GenericProductDao<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;

	private final static int SIZE_PAGE = 2;

	private Class<T> entity;

	protected GenericProductDaoImpl(Class<T> entity) {
		super(entity);
		this.entity = entity;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> sortProductByToMaxPrice() {
		return entityManager.createQuery("FROM" + entity.getSimpleName() + " e ORDER BY e.price DESC", entity)
				.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> sortProductByToMinPrice() {
		return entityManager.createQuery("FROM" + entity.getSimpleName() + " e ORDER BY e.price ASC", entity)
				.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findBetweenPrice(Integer min, Integer max) {
		return entityManager.createQuery("FROM" + entity.getSimpleName() + " e BETWEEN" + min + "AND" + max, entity)
				.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public int findCountPages() {

		long count = entityManager.createQuery("SELECT COUNT(e.id) FROM " + entity.getSimpleName() + " e", Long.class)
				.getSingleResult();

		int countPage = (int) count;

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findProducts(int page) {

		int from = (page - 1) * SIZE_PAGE;

		return entityManager.createQuery("FROM " + entity.getSimpleName(), entity).setFirstResult(from)
				.setMaxResults(SIZE_PAGE).getResultList();

	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findBySearchProductsWithOneSearchWord(String searchWord, int min, int max, int page) {

		int from = (page - 1) * SIZE_PAGE;
		String table = entity.getSimpleName() + "s";

		return entityManager
				.createNativeQuery("SELECT * FROM " + table + " WHERE " + table + ".price BETWEEN :min AND :max and "
						+ table + ".brand LIKE :searchWord" + " or  " + table + ".price BETWEEN :min AND :max and "
						+ table + ".model LIKE :searchWord", entity)
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord + "%")
				.setFirstResult(from).setMaxResults(SIZE_PAGE).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<T> findBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max,
			int page) {

		int from = (page - 1) * SIZE_PAGE;
		String table = entity.getSimpleName() + "s";

		return entityManager
				.createNativeQuery("SELECT * FROM " + table + " WHERE " + table + ".price BETWEEN :min AND :max and "
						+ table + ".brand  LIKE :searchWord and " + table + ".model  LIKE :searchWord2" + " or  "
						+ table + ".price BETWEEN :min AND :max AND " + table + ".brand  LIKE :searchWord2 AND " + table
						+ ".model LIKE :searchWord", entity)
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord + "%")
				.setParameter("searchWord2", searchWord2 + "%").setFirstResult(from).setMaxResults(SIZE_PAGE)
				.getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public int findCountBySearchProductsWithOneSearchWord(String searchWord, int min, int max) {

		String table = entity.getSimpleName() + "s";

		BigInteger bigInteger = (BigInteger) entityManager
				.createNativeQuery("SELECT COUNT(*) FROM " + table + " WHERE " + table
						+ ".price BETWEEN :min AND :max and " + table + ".brand LIKE :searchWord" + " or  " + table
						+ ".price BETWEEN :min AND :max and " + table + ".model LIKE :searchWord")
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord + "%")
				.getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public int findCountBySearchProductsWithTwoSearchWords(String searchWord, String searchWord2, int min, int max) {

		String table = entity.getSimpleName() + "s";
		
		BigInteger bigInteger = (BigInteger) entityManager
				.createNativeQuery("SELECT COUNT(*) FROM " + table + " WHERE " + table
						+ ".price BETWEEN :min AND :max and " + table + ".brand  LIKE :searchWord and " + table
						+ ".model  LIKE :searchWord2" + " or " + table + ".price BETWEEN :min AND :max and " + table
						+ ".brand  LIKE :searchWord2 and " + table + ".model LIKE :searchWord")
				.setParameter("min", min).setParameter("max", max).setParameter("searchWord", searchWord + "%")
				.setParameter("searchWord2", searchWord2 + "%").getSingleResult();

		int countPage = bigInteger.intValue();

		if (countPage % SIZE_PAGE >= 1) {
			countPage = (countPage / SIZE_PAGE) + 1;
		} else {
			countPage /= SIZE_PAGE;
		}

		return countPage;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public int findMaxPriceProduct() {
		return (int) entityManager.createQuery("SELECT MAX(e.price) FROM " + entity.getSimpleName() + " e").getSingleResult();		
	}

}
