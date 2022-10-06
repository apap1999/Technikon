package com.bootcampEuroDyn.technikon;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.PropertyType;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyFunctionalitiesRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyFunctionalitiesImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepairRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyFunctionalitiesService;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;
import com.bootcampEuroDyn.technikon.services.impl.PropertyFunctionalitiesServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyRepairServiceImpl;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {

		EntityManager entityManager = JPAUtil.getEntityManager();


		
		PropertyOwnerRepository propertyOwneRepository= new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwneRepository);
		
		PropertyRepairRepository propertyRepaiRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepaiRepository);
		
		
		PropertyFunctionalitiesRepository propertyRepository = new PropertyFunctionalitiesImpl(entityManager);
		PropertyFunctionalitiesService propertyService = new PropertyFunctionalitiesServiceImpl(propertyRepository);
		
		
		
		
		
		/*------------ OWNER 1 ------------*/
		PropertyOwner propertyOwner = new PropertyOwner();
		propertyOwner.setVatNumber("123");
		propertyOwner.setFirstName("Angelos");
		propertyOwner.setSurname("Tsaousis");
		propertyOwner.setPhoneNumber("69696969");
		propertyOwner.setAddress("asfasgff 21");
		propertyOwner.setEmail("agg@mail.com");
		propertyOwner.setUsername("swolf");
		propertyOwner.setPassward("123456");
		propertyOwnerService.addPropertyOwner(propertyOwner);
		
		/*------------ OWNER 2 ------------*/
		PropertyOwner propertyOwner2 = new PropertyOwner();
		propertyOwner2.setVatNumber("311");
		propertyOwner2.setFirstName("Nick");
		propertyOwner2.setSurname("Petrou");
		propertyOwner2.setPhoneNumber("6969653242969");
		propertyOwner2.setAddress("asfasgff 21");
		propertyOwner2.setEmail("pet@mail.com");
		propertyOwner2.setUsername("retewr");
		propertyOwner2.setPassward("243652346");
		propertyOwnerService.addPropertyOwner(propertyOwner2);
		
		/*------------ PROPERTY 1 ------------*/
		PropertyFunctionalities property = new PropertyFunctionalities();
		property.setPropertyAddress("adgsadgsdg");
		property.setYearOfConstrucitonDate(new Date());
		property.setPropertyType(PropertyType.APARTMENT_BUILDING.name());
		propertyService.addPropertyFunctionalities(property);
		
		
		
		
		/*------------ REPAIR 1 ------------*/
		PropertyRepair repair1 = new PropertyRepair();
		LocalDate localDate = LocalDate.of(2019, 8, 19);
		repair1.setDate(localDate);
		repair1.setDescriptionShort("sort test1");
		repair1.setRepairType(RepairType.ELECTRICAL_WORK);
		repair1.setStatusType(StatusType.COMPLETE);
		repair1.setCost(new BigDecimal("632.5"));
		repair1.setPropertyOwner(propertyOwner);
		repair1.setPorperty(property);
		repair1.setDescriptionBig("big test");
		propertyRepairService.addPropertyRepair(repair1);
		
		/*------------ REPAIR 2 ------------*/

		PropertyRepair repair2 = new PropertyRepair();
		repair2.setDate(LocalDate.of(2019, 9, 1));
		repair2.setDescriptionShort("sort test2");
		repair2.setRepairType(RepairType.FRAMES);
		repair2.setStatusType(StatusType.IN_PROGRESS);
		repair2.setCost(new BigDecimal("412.5"));
		//repair2.setPropertyOwner(propertyOwner2);
		repair2.setPorperty(property);
		repair2.setDescriptionBig("big test2");
		propertyRepairService.addPropertyRepair(repair2);
		
		/*------------ REPAIR 3 ------------*/
		PropertyRepair repair3 = new PropertyRepair();
	
		repair3.setDate(LocalDate.of(2009, 4, 19));
		repair3.setDescriptionShort("sort test3");
		repair3.setRepairType(RepairType.PAINTING);
		repair3.setStatusType(StatusType.PENDING);
		repair3.setCost(new BigDecimal("342.1"));
		repair3.setPropertyOwner(propertyOwner);
		repair3.setPorperty(property);
		repair3.setDescriptionBig("big test3");
		propertyRepairService.addPropertyRepair(repair3);
		
		/*------------ REPAIR 4 ------------*/
		PropertyRepair repair4 = new PropertyRepair();
		repair4.setDate(LocalDate.of(2019, 10, 4));
		repair4.setDescriptionShort("sort test4");
		repair4.setRepairType(RepairType.INULATION);
		repair4.setStatusType(StatusType.COMPLETE);
		repair4.setCost(new BigDecimal("16.8"));
		repair4.setPropertyOwner(propertyOwner2);
		repair4.setPorperty(property);
		repair4.setDescriptionBig("big test4");
		propertyRepairService.addPropertyRepair(repair4);
		
		
		
		System.out.println("-------------------------REPAIR FUNCTIONALITIES TEST----------------------------");
		propertyRepairService.updateDescriptioShort(4, "This is my new description 0");
		
		propertyRepairService.updateDescriptioShort(2, "This is my new description");
		
		propertyRepairService.updateDescriptioShort(1, "This is my new description 2");
		System.out.println("-------------------------AT DATE "+LocalDate.of(2009, 4, 19)+" THE REPARIS ARE----------------------------");
		for(PropertyRepair p: propertyRepairService.searchByDate(LocalDate.of(2009, 4, 19))) {
			System.out.print("Repair Id: " + p.getId());
			System.out.println(" FROM: " + p.getPropertyOwner().getFirstName());
	
		}
		
		System.out.println("-------------------------REPAIR FOR SINGLE USER----------------------------");
		
		for(PropertyRepair p: propertyRepairService.searchById(1)) {
			System.out.println("Repair Id: " + p.getId());
		}
		
		
		System.out.println("-------------------------FROM DATE: "+ LocalDate.of(2019, 8, 1) + " UNTIL DATE: " + LocalDate.of(2019, 10, 30) +" ----------------------------");
		for(PropertyRepair p: propertyRepairService.searchByDateRange(LocalDate.of(2019, 8, 1), LocalDate.of(2019, 10, 30))) {
			System.out.println("Repair Id: " + p.getId());
		}
		
		
		
		
		propertyOwnerService.displayPropertyOwners();
		
		JPAUtil.shutdown();

	}

}