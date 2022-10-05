package com.bootcampEuroDyn.technikon.utility;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;

public class LoadRecords {
	
	
	public void loadOwner(String vatNumber, String firstName,
			String surname, String phoneNumber,String address, String email, String username, String passwords) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		Repository<PropertyOwner, Long> ownerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerService(ownerRepository);

		PropertyOwner propertyOwner = new PropertyOwner();
		try {
			propertyOwner.setVatNumber(vatNumber);
			propertyOwner.setFirstName(firstName);
			propertyOwner.setSurname(surname);
			propertyOwner.setPhoneNumber(phoneNumber);
			propertyOwner.setAddress(address);
			propertyOwner.setEmail(email);
			propertyOwner.setUsername(username);
			propertyOwner.setPassward(passwords);
			propertyOwner.setDeleted(false);
			propertyOwnerService.addPropertyOwner(propertyOwner);
		} catch (IsValidPropertyOwner e) {
			if(entityManager.getTransaction()!=null) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	
	}
	
}
