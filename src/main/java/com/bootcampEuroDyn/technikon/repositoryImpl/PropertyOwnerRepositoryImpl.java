package com.bootcamp.technikon.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;

import com.bootcamp.technikon.domain.PropertyOwner;
import com.bootcamp.technikon.repository.PropertyOwnerRepository;

public class PropertyOwnerRepositoryImpl implements PropertyOwnerRepository{
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("technikon");
	
	@Override
	public void addPropertyOwner(String vatNumber, String firstName,
					String surname, String phoneNumber, String email, String username, String passwords) {
		// The EntityManager class allows operations such as create, read, update, delete
				EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
				// Used to issue transactions on the EntityManager
				EntityTransaction eTransaction = null;
				try {
					// Get transaction and start
					eTransaction = eManager.getTransaction();
					eTransaction.begin();
					// Create and set values for new customer
					PropertyOwner propertyOwner = new PropertyOwner();
					propertyOwner.setVatNumber(vatNumber);
					propertyOwner.setFirstName(firstName);
					propertyOwner.setSurname(surname);
					propertyOwner.setPhoneNumber(phoneNumber);
					propertyOwner.setEmail(email);
					propertyOwner.setUsername(username);
					propertyOwner.setPassward(passwords);
					propertyOwner.setDeleted(false);
					// Save the customer object
					eManager.persist(propertyOwner);
					eTransaction.commit();
				}catch (Exception e) {
					// If there is an exception rollback changes
					if(eTransaction != null) {
						eTransaction.rollback();
					}
					e.printStackTrace();
				}finally {
					// Close EntityManager
					eManager.close();
				}
		
	}

	@Override
	public void getPropertyOwners() {
		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
		String qString = "SELECT c FROM PropertyOwner c WHERE c.id IS NOT NULL";
		// Issue the query and get a matching Customer
		TypedQuery<PropertyOwner> tQuery = eManager.createQuery(qString,PropertyOwner.class);
		List<PropertyOwner> customersList;
		try {
			// Get matching customer object and output
			customersList = tQuery.getResultList();
			customersList.forEach(property_owner->System.out.println("{" +property_owner.getVatNumber() + " " +
																		  property_owner.getFirstName() + " " + 
																		  property_owner.getSurname() + " " +
																		  property_owner.getPhoneNumber() + " " +
																		  property_owner.getEmail() + " " + 
																		  property_owner.getUsername() + " " + 
																		  property_owner.getPassward() + "}"));
		}catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
		}finally {
			eManager.close();
		}
		
	}

	@Override
	public void getPropertyOwner(long id) {
		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
		String queryString = "SELECT c FROM PropertyOwner c WHERE c.id = :_id";
		// Issue the query and get a matching Customer
		TypedQuery<PropertyOwner> tQuery = eManager.createQuery(queryString,PropertyOwner.class);
		tQuery.setParameter("_id", id);
		PropertyOwner propertyOwner = null;
		try {
			// Get matching customer object and output
			propertyOwner = tQuery.getSingleResult();
			System.out.println("{" + propertyOwner.getVatNumber() + " " +
									 propertyOwner.getFirstName() + " " + 
									 propertyOwner.getSurname() + " " +
									 propertyOwner.getPhoneNumber() + " " +
									 propertyOwner.getEmail() + " " + 
									 propertyOwner.getUsername() + " " + 
									 propertyOwner.getPassward() + "}");
		}catch (NoResultException e) {
			System.out.println("NoResultException" + e.getMessage());
		}finally {
			eManager.close();
		}
		
	}

	@Override
	public void updateProperyOwnerAddress(long id, String address) {
		
		
	}

	@Override
	public void updateProperyOwnerEmail(String vatNumber, String email) {
		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction = null;
		PropertyOwner propertyOwner = null;
		try {
			 // Get transaction and start
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			 // Find customer and make changes
			propertyOwner = eManager.find(PropertyOwner.class, vatNumber);
			propertyOwner.setEmail(email);;	
			// Save the customer object
			eManager.persist(propertyOwner);
			eTransaction.commit();
		}catch (Exception e) {
			// If there is an exception rollback changes
			if(eTransaction != null) {
				eTransaction.rollback();
			}
			e.printStackTrace();
		}finally {
			// Close EntityManager
			eManager.close();
		}
		
	}

	@Override
	public void updateProperyOwnerPassword(long id, String password) {
		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction = null;
		PropertyOwner propertyOwner = null;
		try {
			 // Get transaction and start
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			 // Find customer and make changes
			propertyOwner = eManager.find(PropertyOwner.class, id);
			propertyOwner.setPassward(password);;	
			// Save the customer object
			eManager.persist(propertyOwner);
			eTransaction.commit();
		}catch (Exception e) {
			// If there is an exception rollback changes
			if(eTransaction != null) {
				eTransaction.rollback();
			}
			e.printStackTrace();
		}finally {
			// Close EntityManager
			eManager.close();
		}
		
	}

	@Override
	@PreRemove
	public void safelyDeletePropertyOwner(long id) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction entityTransaction = null;
		PropertyOwner propertyOwner = null;
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			propertyOwner = entityManager.find(PropertyOwner.class, id);
			propertyOwner.setDeleted(true);
			entityTransaction.commit();
		}catch (Exception e) {
			if(entityTransaction != null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	}
}
