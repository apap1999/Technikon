package com.bootcampEuroDyn.technikon;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		Repository<PropertyOwner, Long> ownerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerService(ownerRepository);
		
		PropertyOwner owner  = new PropertyOwner();
		
		owner.setVatNumber("123456789");owner.setFirstName("Orfeas");owner.setSurname("Marougkas");owner.setPhoneNumber("6981334563");owner.setEmail("orfeas@email.com");owner.setUsername("user");owner.setPassward("pass");  owner.setDeleted(false);
		propertyOwnerService.addPropertyOwner(owner);
		
		owner.setVatNumber("987654321");owner.setFirstName("Andreas");owner.setSurname("Papadias");owner.setPhoneNumber("6945631821");owner.setEmail("andreas@email.com");owner.setUsername("root");owner.setPassward("qwe");  owner.setDeleted(false);
		propertyOwnerService.addPropertyOwner(owner);
		
		owner.setVatNumber("567891234");owner.setFirstName("Aggelos");owner.setSurname("Tsaousis");owner.setPhoneNumber("6992738219");owner.setEmail("aggelos@email.com");owner.setUsername("admin");owner.setPassward("1234");  owner.setDeleted(false);
		propertyOwnerService.addPropertyOwner(owner);
		
		owner.setVatNumber("012345678");owner.setFirstName("Dimitris");owner.setSurname("Papadopoulos");owner.setPhoneNumber("6955537213");owner.setEmail("dimitris@email.com");owner.setUsername("mitsos");owner.setPassward("lol123");  owner.setDeleted(false);
		propertyOwnerService.addPropertyOwner(owner);
		
		owner.setVatNumber("537281937");owner.setFirstName("John");owner.setSurname("Loulos");owner.setPhoneNumber("6980029569");owner.setEmail("john@email.com");owner.setUsername("flower");owner.setPassward("my_pass123");  owner.setDeleted(false);
		propertyOwnerService.addPropertyOwner(owner);
		
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
