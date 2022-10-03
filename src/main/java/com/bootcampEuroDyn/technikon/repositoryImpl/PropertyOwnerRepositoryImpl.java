package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.Optional;
import java.util.function.LongFunction;

import javax.persistence.EntityManager;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;


public class PropertyOwnerRepositoryImpl extends RepositoryImpl<PropertyOwner, Long> implements PropertyOwnerRepository{
	
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
	public boolean updateProperyOwnerAddress(long properyOwnerId, String newAddress) {
		return false;
	}

	@Override
	public boolean updateProperyOwnerEmail(long properyOwnerId, String newEmail) {
		Optional<PropertyOwner> propertyOwner = read(properyOwnerId);
		if(propertyOwner == null) {
			return false;
		}
		for (PropertyOwner curPropertyOwner:read(1,10)){
            if (curPropertyOwner.getEmail()!=null && curPropertyOwner.getEmail().equals(newEmail)){
                   return false;
            }
        }
        
		//propertyOwner.setEmail(newEmail);
        return true;
	}

	@Override
	public boolean updateProperyOwnerPassword(long id, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * End of PropertyOwnerImpl
	 */

//
//	@Override
//	public List<PropertyOwner> getPropertyOwners() {
//		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		// the lowercase c refers to the object
//    	// :custID is a parameterized query thats value is set below
//		String qString = "SELECT c FROM PropertyOwner c WHERE c.id IS NOT NULL";
//		// Issue the query and get a matching Customer
//		TypedQuery<PropertyOwner> tQuery = eManager.createQuery(qString,PropertyOwner.class);
//		List<PropertyOwner> customersList = null;
//		try {
//			// Get matching customer object and output
//			customersList = tQuery.getResultList();
//			customersList.forEach(property_owner->System.out.println("{" +property_owner.getVatNumber() + " " +
//																		  property_owner.getFirstName() + " " + 
//																		  property_owner.getSurname() + " " +
//																		  property_owner.getPhoneNumber() + " " +
//																		  property_owner.getEmail() + " " + 
//																		  property_owner.getUsername() + " " + 
//																		  property_owner.getPassward() + "}"));
//		}catch (NoResultException e) {
//			System.out.println("NoResultException" + e.getMessage());
//		}finally {
//			eManager.close();
//		}
//		return customersList;
//		
//	}
//
//	@Override
//	public Optional<PropertyOwner> getPropertyOwner(long id) {
//		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		// the lowercase c refers to the object
//    	// :custID is a parameterized query thats value is set below
//		String queryString = "SELECT c FROM PropertyOwner c WHERE c.id = :_id";
//		// Issue the query and get a matching Customer
//		TypedQuery<PropertyOwner> tQuery = eManager.createQuery(queryString,PropertyOwner.class);
//		tQuery.setParameter("_id", id);
//		PropertyOwner propertyOwner = null;
//		try {
//			// Get matching customer object and output
//			propertyOwner = tQuery.getSingleResult();
//			System.out.println("{" + propertyOwner.getVatNumber() + " " +
//									 propertyOwner.getFirstName() + " " + 
//									 propertyOwner.getSurname() + " " +
//									 propertyOwner.getPhoneNumber() + " " +
//									 propertyOwner.getEmail() + " " + 
//									 propertyOwner.getUsername() + " " + 
//									 propertyOwner.getPassward() + "}");
//		}catch (NoResultException e) {
//			System.out.println("NoResultException" + e.getMessage());
//		}finally {
//			eManager.close();
//		}
//		return null;
//		
//	}
//
//	@Override
//	public void updateProperyOwnerAddress(long id, String address) {
//		
//		
//	}
//
//	@Override
//	public void updateProperyOwnerEmail(String vatNumber, String email) {
//		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction eTransaction = null;
//		PropertyOwner propertyOwner = null;
//		try {
//			 // Get transaction and start
//			eTransaction = eManager.getTransaction();
//			eTransaction.begin();
//			 // Find customer and make changes
//			propertyOwner = eManager.find(PropertyOwner.class, vatNumber);
//			propertyOwner.setEmail(email);;	
//			// Save the customer object
//			eManager.persist(propertyOwner);
//			eTransaction.commit();
//		}catch (Exception e) {
//			// If there is an exception rollback changes
//			if(eTransaction != null) {
//				eTransaction.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			// Close EntityManager
//			eManager.close();
//		}
//		
//	}
//
//	@Override
//	public void updateProperyOwnerPassword(long id, String password) {
//		EntityManager eManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction eTransaction = null;
//		PropertyOwner propertyOwner = null;
//		try {
//			 // Get transaction and start
//			eTransaction = eManager.getTransaction();
//			eTransaction.begin();
//			 // Find customer and make changes
//			propertyOwner = eManager.find(PropertyOwner.class, id);
//			propertyOwner.setPassward(password);;	
//			// Save the customer object
//			eManager.persist(propertyOwner);
//			eTransaction.commit();
//		}catch (Exception e) {
//			// If there is an exception rollback changes
//			if(eTransaction != null) {
//				eTransaction.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			// Close EntityManager
//			eManager.close();
//		}
//		
//	}
//
//	@Override
//	@PreRemove
//	public boolean safelyDeletePropertyOwner(long id) {
//		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction entityTransaction = null;
//		PropertyOwner propertyOwner = null;
//		try {
//			entityTransaction = entityManager.getTransaction();
//			entityTransaction.begin();
//			propertyOwner = entityManager.find(PropertyOwner.class, id);
//			propertyOwner.setDeleted(true);
//			entityTransaction.commit();
//		}catch (Exception e) {
//			if(entityTransaction != null) {
//				entityTransaction.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			entityManager.close();
//		}
//		return false;
//	}
//

	
}
