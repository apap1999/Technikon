package com.bootcampEuroDyn.technikon;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;
import com.bootcampEuroDyn.technikon.utility.LoadRecords;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		Repository<PropertyOwner, Long> ownerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerService(ownerRepository);
		new LoadRecords().loadOwner("123456789", "Orfeas", "Marougkas", "6981334563", "Greece","orfeas@email.com", "user", "pass");
		new LoadRecords().loadOwner("987654321", "Andreas", "Papadias", "6945631821", "Greece","andreas@email.com", "root", "qwe");
		new LoadRecords().loadOwner("567891234", "Aggelos", "Tsaousis", "6992738219", "Greece","aggelos@email.com", "admin", "1234");
		new LoadRecords().loadOwner("012345678", "Dimitris", "Papadopoulos", "6955537213", "Greece","dimitris@email.com", "mitsos", "lol123");
		new LoadRecords().loadOwner("537281937", "John", "Loulos", "6980029569", "Greece","john@email.com", "flower", "my_pass123");
		propertyOwnerService.displayPropertyOwners();
		//propertyOwnerService.dispLayPropertyOwner(3);
		PropertyOwnerRepositoryImpl propertyOwnerRepositoryImpl = new PropertyOwnerRepositoryImpl(entityManager);
		propertyOwnerRepositoryImpl.updateProperyOwnerAddress(1, "Albania");
		propertyOwnerService.deletePropertyOwner(4L);
		propertyOwnerService.displayPropertyOwners();
		JPAUtil.shutdown();
		//		PropertyOwnerRepositoryImpl test = new PropertyOwnerRepositoryImpl();
//		//vatNumber, firstName, surname, phoneNumber, email, username, passwords
//		test.addPropertyOwner("123456789", "Orfeas", "Marougkas", "6981334563", "orfeas@email.com", "user", "pass");
//		test.addPropertyOwner("987654321", "Andreas", "Papadias", "6945631821", "andreas@email.com", "root", "qwe");
//		test.addPropertyOwner("567891234", "Aggelos", "Tsaousis", "6992738219", "aggelos@email.com", "admin", "1234");
//		test.addPropertyOwner("012345678", "Dimitris", "Papadopoulos", "6955537213", "dimitris@email.com", "mitsos", "lol123");
//		test.addPropertyOwner("537281937", "John", "Loulos", "6980029569", "john@email.com", "flower", "my_pass123");
//		test.getPropertyOwners();
//		test.safelyDeletePropertyOwner(5);
//		test.safelyDeletePropertyOwner(4);
//		test.getPropertyOwners();
	}

}
