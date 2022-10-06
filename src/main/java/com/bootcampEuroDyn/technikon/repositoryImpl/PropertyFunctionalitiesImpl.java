package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;
import com.bootcampEuroDyn.technikon.repository.PropertyFunctionalitiesRepository;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class PropertyFunctionalitiesImpl extends RepositoryImpl<PropertyFunctionalities, Long>
		implements PropertyFunctionalitiesRepository {

	public PropertyFunctionalitiesImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {
		return PropertyFunctionalities.class.getName();
	}

	@Override
	public Class<PropertyFunctionalities> getEntityClass() {
		return PropertyFunctionalities.class;
	}

	@Override
	public Optional<PropertyFunctionalities> add(PropertyFunctionalities t) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
			return Optional.of(t);
		} catch (Exception e) {
			if (entityManager.getTransaction() != null) {
				entityManager.getTransaction().rollback();
			}
			return Optional.empty();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<PropertyFunctionalities> read(int pageNumber, int pageSize) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		String querryString = "SELECT c FROM PropertyFunctionalities c WHERE c.id IS NOT NULL";
		TypedQuery<PropertyFunctionalities> tQuery = entityManager.createQuery(querryString,PropertyFunctionalities.class);

		List<PropertyFunctionalities> PropertyFunctionalitiesList = null;
		try {
			PropertyFunctionalitiesList = tQuery.getResultList();
			PropertyFunctionalitiesList.forEach(property_functionalities -> System.out.println(
					"{" + property_functionalities.getPropertyId() + " " + property_functionalities.getPropertyAddress()
							+ " " + property_functionalities.getYearOfConstrucitonDate() + " "
							+ property_functionalities.getPropertyType() + " " + "}"));

		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
		} finally {
			entityManager.close();
		}
		return PropertyFunctionalitiesList;
	}

	@Override
	public Optional<PropertyFunctionalities> read(Long tId) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		String queryString = "SELECT c FROM PropertyFunctionalities c WHERE c.id = :_id";
		TypedQuery<PropertyFunctionalities> tQuery = entityManager.createQuery(queryString,PropertyFunctionalities.class);
		tQuery.setParameter("_id", tId);
		PropertyFunctionalities propertyFunctionalities = null;
		try {
			propertyFunctionalities = tQuery.getSingleResult();
			System.out.println(
					"{" + propertyFunctionalities.getPropertyId() + " " + propertyFunctionalities.getPropertyAddress()
							+ " " + propertyFunctionalities.getYearOfConstrucitonDate() + " "
							+ propertyFunctionalities.getPropertyType() + " " + "}");
			return Optional.of(propertyFunctionalities);
		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
			return Optional.empty();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public boolean updatePropertyFunctionalityAddress(long properyFunctionalityId, String newAddress) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyFunctionalities propertyFunctionalities = null;
		try {
			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(PropertyFunctionalities.class, properyFunctionalityId);
			propertyFunctionalities.setPropertyAddress(newAddress);
			entityManager.persist(propertyFunctionalities);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (entityManager.getTransaction() != null) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean updatePropertyFunctionalityYearOfConstructionDate(long properyFunctionalityId,
			Date newYearOfConstructiongDate) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyFunctionalities propertyFunctionalities = null;
		try {
			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(PropertyFunctionalities.class, properyFunctionalityId);
			propertyFunctionalities.setYearOfConstrucitonDate(newYearOfConstructiongDate);
			entityManager.persist(propertyFunctionalities);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (entityManager.getTransaction() != null) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean updatePropertyFunctionalityPropertyType(long id, String newPropertyType) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyFunctionalities propertyFunctionalities = null;
		try {
			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(PropertyFunctionalities.class, id);
			propertyFunctionalities.setPropertyType(newPropertyType);
			entityManager.persist(propertyFunctionalities);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (entityManager.getTransaction() != null) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}

	@PreRemove
	@Override
	public boolean delete(Long tId) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyFunctionalities propertyFunctionalities = null;
		try {

			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(PropertyFunctionalities.class, tId);
			propertyFunctionalities.setDeleted(true);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (entityManager.getTransaction() != null) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();

		}

	}
}
