package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;

import com.bootcampEuroDyn.technikon.model.Property;
import com.bootcampEuroDyn.technikon.repository.PropertyRepository;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class PropertyRepositoryImpl extends RepositoryImpl<Property, Long>
		implements PropertyRepository {

	public PropertyRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {
		return Property.class.getName();
	}

	@Override
	public Class<Property> getEntityClass() {
		return Property.class;
	}

	@Override
	public Optional<Property> add(Property t) {
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
	public List<Property> read(int pageNumber, int pageSize) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		String querryString = "SELECT c FROM Property c WHERE c.id IS NOT NULL";
		TypedQuery<Property> tQuery = entityManager.createQuery(querryString,Property.class);

		List<Property> PropertyFunctionalitiesList = null;
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
	public Optional<Property> read(Long tId) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		String queryString = "SELECT c FROM PropertyFunctionalities c WHERE c.id = :_id";
		TypedQuery<Property> tQuery = entityManager.createQuery(queryString,Property.class);
		tQuery.setParameter("_id", tId);
		Property propertyFunctionalities = null;
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
	public boolean updatePropertyFunctionalityAddress(long properyId, String newAddress) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		Property property = null;
		try {
			
			entityManager.getTransaction().begin();
			property = entityManager.find(Property.class, properyId);
			property.setPropertyAddress(newAddress);
			entityManager.persist(property);
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
		Property propertyFunctionalities = null;
		try {
			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(Property.class, properyFunctionalityId);
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
		Property propertyFunctionalities = null;
		try {
			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(Property.class, id);
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
		Property propertyFunctionalities = null;
		try {

			entityManager.getTransaction().begin();
			propertyFunctionalities = entityManager.find(Property.class, tId);
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
