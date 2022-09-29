package com.bootcamp.technikon.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bootcamp.technikon.domain.PropertyOwner;
import com.bootcamp.technikon.repository.PropertyOwnerRepository;
import com.bootcamp.technikon.repository.impl.PropertyOwnerRepositoryImpl;
import com.bootcamp.technikon.utility.JPAUtil;


public class PropertyOwnerService {
	
//	private EntityManager entityManager;
//	private PropertyOwnerRepository propertyOwnerRepo;
//	
//	public PropertyOwnerService() {
//		entityManager = JPAUtil.getEntityManager();
//		propertyOwnerRepo = new PropertyOwnerRepositoryImpl(entityManager);
//	}
//	
//	public void loadPropertyOwners(String vatNumber, String firstName, String surname,
//			String phoneNumber, String email, String username, String passwords) {
//		// Used to issue transactions on the EntityManager
//		EntityTransaction eTransaction = null;
//		try {
//			// Get transaction and start
//			eTransaction = entityManager.getTransaction();
//			eTransaction.begin();
//			// Create and set values for new customer
//			PropertyOwner propertyOwner = new PropertyOwner();
//			propertyOwner.setVatNumber(vatNumber);
//			propertyOwner.setFirstName(firstName);
//			propertyOwner.setSurname(surname);
//			propertyOwner.setPhoneNumber(phoneNumber);
//			propertyOwner.setEmail(email);
//			propertyOwner.setUsername(username);
//			propertyOwner.setPassward(passwords);
//			propertyOwner.setDeleted(false);
//			// Save the customer object
//			entityManager.persist(propertyOwner);
//			eTransaction.commit();
//		}catch (Exception e) {
//			// If there is an exception rollback changes
//			if(eTransaction != null && eTransaction.isActive()) {
//				eTransaction.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			 //Close EntityManager
//			entityManager.close();
//		}
//	}
	 
}
