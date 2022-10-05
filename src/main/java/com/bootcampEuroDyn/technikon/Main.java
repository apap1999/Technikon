package com.bootcampEuroDyn.technikon;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.domain.RepairType;
import com.bootcampEuroDyn.technikon.domain.StatusType;
import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepairRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;
import com.bootcampEuroDyn.technikon.services.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyRepairServiceImpl;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Repository<PropertyOwner, Long> propertyOwneRepository= new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerServiceImpl propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwneRepository);
		
		Repository<PropertyRepair, Long> propertyRepaiRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepaiRepository);
		
		PropertyOwner propertyOwner = new PropertyOwner();
		propertyOwner.setVatNumber("123");
		propertyOwner.setFirstName("Angelos");
		propertyOwner.setSurname("Tsaousis");
		propertyOwner.setPhoneNumber("69696969");
		propertyOwner.setEmail("agg@mail.com");
		propertyOwner.setUsername("swolf");
		propertyOwner.setPassward("123456");
		propertyOwnerService.addPropertyOwner(propertyOwner);
		
		PropertyRepair repair = new PropertyRepair();
		repair.setDate(new Date());
		repair.setDescriptionShort("sort test");
		repair.setRepairType(RepairType.ELECTRICAL_WORK);
		repair.setStatusType(StatusType.COMPLETE);
		repair.setCost(new BigDecimal("632.5"));
		repair.setPropertyOwner(propertyOwner);
		repair.setPropertyID(22);
		repair.setDescriptionBig("big test");
		propertyRepairService.addPropertyRepair(repair);
		
		
		PropertyOwner propertyOwner2 = new PropertyOwner();
		propertyOwner2.setVatNumber("311");
		propertyOwner2.setFirstName("Nick");
		propertyOwner2.setSurname("Petrou");
		propertyOwner2.setPhoneNumber("6969653242969");
		propertyOwner2.setEmail("pet@mail.com");
		propertyOwner2.setUsername("retewr");
		propertyOwner2.setPassward("243652346");
		propertyOwnerService.addPropertyOwner(propertyOwner2);
		
		
		PropertyRepair repair2 = new PropertyRepair();
		repair2.setDate(new Date());
		repair2.setDescriptionShort("sort test2");
		repair2.setRepairType(RepairType.FRAMES);
		repair2.setStatusType(StatusType.IN_PROGRESS);
		repair2.setCost(new BigDecimal("412.5"));
		repair2.setPropertyOwner(propertyOwner2);
		repair2.setPropertyID(54);
		repair2.setDescriptionBig("big test2");
		propertyRepairService.addPropertyRepair(repair2);
		
		System.out.println("-----------------------------------------------------");
		System.out.println(propertyRepairService.searchPropertyRepair(2).getPropertyOwner().getFirstName());
		System.out.println("-----------------------------------------------------");
		
		JPAUtil.shutdown();
		
		
//		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(entityManager);
//		
//		
//		PropertyRepair propertyRepair = new PropertyRepair();
//		propertyRepair.setDate(new Date());
//		propertyRepair.setDescriptionShort("sort test");
//		propertyRepair.setRepairType(RepairType.ELECTRICAL_WORK);
//		propertyRepair.setStatusType(StatusType.COMPLETE);
//		propertyRepair.setCost(new BigDecimal("632.5"));
//		propertyRepair.setPropertyID(22);
//		propertyRepair.setDescriptionBig("big test");
//		
//		propertyRepairService.addPropertyRepair(propertyRepair);
//		
//		
//		
		
		
		
		
		
//		Repository<PropertyOwner, Long> ownerRepository = new PropertyOwnerRepositoryImpl(entityManager);
//		PropertyOwnerService propertyOwnerService = new PropertyOwnerService(ownerRepository);
//		
//		PropertyOwner owner  = new PropertyOwner();
//		
//		owner.setVatNumber("123456789");owner.setFirstName("Orfeas");owner.setSurname("Marougkas");owner.setPhoneNumber("6981334563");owner.setEmail("orfeas@email.com");owner.setUsername("user");owner.setPassward("pass");  owner.setDeleted(false);
//		propertyOwnerService.addPropertyOwner(owner);
//		
//		owner.setVatNumber("987654321");owner.setFirstName("Andreas");owner.setSurname("Papadias");owner.setPhoneNumber("6945631821");owner.setEmail("andreas@email.com");owner.setUsername("root");owner.setPassward("qwe");  owner.setDeleted(false);
//		propertyOwnerService.addPropertyOwner(owner);
//		
//		owner.setVatNumber("567891234");owner.setFirstName("Aggelos");owner.setSurname("Tsaousis");owner.setPhoneNumber("6992738219");owner.setEmail("aggelos@email.com");owner.setUsername("admin");owner.setPassward("1234");  owner.setDeleted(false);
//		propertyOwnerService.addPropertyOwner(owner);
//		
//		owner.setVatNumber("012345678");owner.setFirstName("Dimitris");owner.setSurname("Papadopoulos");owner.setPhoneNumber("6955537213");owner.setEmail("dimitris@email.com");owner.setUsername("mitsos");owner.setPassward("lol123");  owner.setDeleted(false);
//		propertyOwnerService.addPropertyOwner(owner);
//		
//		owner.setVatNumber("537281937");owner.setFirstName("John");owner.setSurname("Loulos");owner.setPhoneNumber("6980029569");owner.setEmail("john@email.com");owner.setUsername("flower");owner.setPassward("my_pass123");  owner.setDeleted(false);
//		propertyOwnerService.addPropertyOwner(owner);
//		
//		propertyOwnerService.displayPropertyOwners();
		
		
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
