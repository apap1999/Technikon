package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

/**
 * This Class extends the generic type interface (Repository) and Overrides its
 * methods (Add-Read-Delete). It also implements the PropertyOwnerRepository
 * which contains the Update and Search functions. Each function makes a
 * Transaction with the database. Receives the EntityManager from the JAPUtil
 * class.
 */
public class PropertyOwnerRepositoryImpl extends RepositoryImpl<PropertyOwner, Long>
		implements PropertyOwnerRepository {

	public PropertyOwnerRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {
		return PropertyOwner.class.getName();
	}

	@Override
	public Class<PropertyOwner> getEntityClass() {
		return PropertyOwner.class;
	}

	@Override
	public Optional<PropertyOwner> add(PropertyOwner t) {
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
	public List<PropertyOwner> read(int pageNumber, int pageSize) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		// the lower case c refers to the object
		String querryString = "SELECT c FROM PropertyOwner c WHERE c.id IS NOT NULL";
		TypedQuery<PropertyOwner> tQuery = entityManager.createQuery(querryString, PropertyOwner.class);
		List<PropertyOwner> propertyOwnersList = null;
		try {
			propertyOwnersList = tQuery.getResultList();
			// For UI purposes
			propertyOwnersList.forEach(property_owner -> System.out.println("{" + property_owner.getVatNumber() + ", "
					+ property_owner.getFirstName() + ", " + property_owner.getSurname() + ", "
					+ property_owner.getPhoneNumber() + ", " + property_owner.getAddress() + ", "
					+ property_owner.getEmail() + ", " + property_owner.getUsername() + ", "
					+ property_owner.getPassward().replaceAll("[\\s\\S]*", "*") + "}"));
		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
		} finally {
			entityManager.close();
		}
		return propertyOwnersList;
	}

	@Override
	public Optional<PropertyOwner> read(Long tId) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		String queryString = "SELECT c FROM PropertyOwner c WHERE c.id = :_id";
		TypedQuery<PropertyOwner> tQuery = entityManager.createQuery(queryString, PropertyOwner.class);
		tQuery.setParameter("_id", tId);
		PropertyOwner propertyOwner = null;
		try {
			propertyOwner = tQuery.getSingleResult();
			System.out.println("{" + propertyOwner.getVatNumber() + ", " + propertyOwner.getFirstName() + ", "
					+ propertyOwner.getSurname() + ", " + propertyOwner.getPhoneNumber() + " " + propertyOwner.getEmail()
					+ ", " + propertyOwner.getUsername() + ", "
					+ propertyOwner.getPassward().replaceAll("[\\s\\S]*", "*") + "}");
			return Optional.of(propertyOwner);
		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
			return Optional.empty();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean updateProperyOwnerAddress(long properyOwnerId, String newAddress) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyOwner propertyOwner = null;
		try {
			entityManager.getTransaction().begin();
			propertyOwner = entityManager.find(PropertyOwner.class, properyOwnerId);
			propertyOwner.setAddress(newAddress);
			entityManager.persist(propertyOwner);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// If there is an exception roll back changes
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
	public boolean updateProperyOwnerEmail(long properyOwnerId, String newEmail) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyOwner propertyOwner = null;
		try {
			entityManager.getTransaction().begin();
			propertyOwner = entityManager.find(PropertyOwner.class, properyOwnerId);
			propertyOwner.setEmail(newEmail);
			entityManager.persist(propertyOwner);
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
	public boolean updateProperyOwnerPassword(long id, String newPassword) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PropertyOwner propertyOwner = null;
		try {
			entityManager.getTransaction().begin();
			propertyOwner = entityManager.find(PropertyOwner.class, id);
			propertyOwner.setPassward(newPassword);
			entityManager.persist(propertyOwner);
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
		PropertyOwner propertyOwner = null;
		try {

			entityManager.getTransaction().begin();
			propertyOwner = entityManager.find(PropertyOwner.class, tId);
			propertyOwner.setDeleted(true);
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
	public Optional<PropertyOwner> searchByVatNumber(String vat) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		String searchVatQuery = "SELECT c FROM PropertyOwner c WHERE c.vatNumber = :vatNumber";
		TypedQuery<PropertyOwner> tQuery = entityManager.createQuery(searchVatQuery, PropertyOwner.class);
		tQuery.setParameter("vatNumber", vat);
		PropertyOwner propertyOwner = null;
		try {
			propertyOwner = tQuery.getSingleResult();
			System.out.println("{" + propertyOwner.getVatNumber() + ", " + propertyOwner.getFirstName() + ", "
					+ propertyOwner.getSurname() + ", " + propertyOwner.getPhoneNumber() + ", " + propertyOwner.getEmail()
					+ ", " + propertyOwner.getUsername() + ", "
					+ propertyOwner.getPassward().replaceAll("[\\s\\S]*", "*") + "}");
			return Optional.of(propertyOwner);
		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
			return Optional.empty();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Optional<PropertyOwner> searchByEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		String searchEmailQuery = "SELECT c FROM PropertyOwner c WHERE c.email = :email";
		TypedQuery<PropertyOwner> tQuery = entityManager.createQuery(searchEmailQuery, PropertyOwner.class);
		tQuery.setParameter("email", email);
		PropertyOwner propertyOwner = null;
		try {
			propertyOwner = tQuery.getSingleResult();
			System.out.println("{" + propertyOwner.getVatNumber() + ", " + propertyOwner.getFirstName() + ", "
					+ propertyOwner.getSurname() + ", " + propertyOwner.getPhoneNumber() + ", " + propertyOwner.getEmail()
					+ " " + propertyOwner.getUsername() + ", "
					+ propertyOwner.getPassward().replaceAll("[\\s\\S]*", "*") + "}");
			return Optional.of(propertyOwner);
		} catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
			return Optional.empty();
		} finally {
			entityManager.close();
		}
	}

}
