package com.bootcampEuroDyn.technikon.UI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.model.Property;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.PropertyType;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyRepository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepairRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepositoryImpl;
import com.bootcampEuroDyn.technikon.service.PropertyOwnerService;
import com.bootcampEuroDyn.technikon.service.PropertyRepairService;
import com.bootcampEuroDyn.technikon.service.PropertyService;
import com.bootcampEuroDyn.technikon.service.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.service.impl.PropertyRepairServiceImpl;
import com.bootcampEuroDyn.technikon.service.impl.PropertyServiceImpl;

public class Data {
	
	public void getData(EntityManager entityManager) {
		
		PropertyOwnerRepository propertyOwneRepository= new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwneRepository);
		
		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);
		
		PropertyRepairRepository propertyRepaiRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepaiRepository);
		
		
		
		

		/*-----------------------OWNERS-------------------------*/
		/*-----------------------OWNER1-------------------------*/
		PropertyOwner propertyOwner1 = new PropertyOwner();
		propertyOwner1.setVatNumber("123");
		propertyOwner1.setFirstName("Angelos");
		propertyOwner1.setSurname("Tsaousis");
		propertyOwner1.setPhoneNumber("697012344123");
		propertyOwner1.setAddress("Sofokleous 21");
		propertyOwner1.setEmail("aggelos@mail.com");
		propertyOwner1.setUsername("swolf");
		propertyOwner1.setPassward("123456");
		propertyOwnerService.addPropertyOwner(propertyOwner1);
		
		/*-----------------------OWNER2-------------------------*/
		PropertyOwner propertyOwner2 = new PropertyOwner();
		propertyOwner2.setVatNumber("532");
		propertyOwner2.setFirstName("Orfeas");
		propertyOwner2.setSurname("Marougas");
		propertyOwner2.setPhoneNumber("6963463");
		propertyOwner2.setAddress("Patras 11");
		propertyOwner2.setEmail("orfeas@mail.com");
		propertyOwner2.setUsername("sorf98");
		propertyOwner2.setPassward("1543246");
		propertyOwnerService.addPropertyOwner(propertyOwner2);
		
		/*-----------------------OWNER3-------------------------*/
		PropertyOwner propertyOwner3 = new PropertyOwner();
		propertyOwner3.setVatNumber("879");
		propertyOwner3.setFirstName("Andreas");
		propertyOwner3.setSurname("Papadias");
		propertyOwner3.setPhoneNumber("690942671w4");
		propertyOwner3.setAddress("Megalou Alexandrou 21");
		propertyOwner3.setEmail("andreas@mail.com");
		propertyOwner3.setUsername("apap");
		propertyOwner3.setPassward("156434456");
		propertyOwnerService.addPropertyOwner(propertyOwner3);
		
		/*-----------------------OWNER4-------------------------*/
		PropertyOwner propertyOwner4 = new PropertyOwner();
		propertyOwner4.setVatNumber("951");
		propertyOwner4.setFirstName("Nikos");
		propertyOwner4.setSurname("Papadopoulos");
		propertyOwner4.setPhoneNumber("6923864512");
		propertyOwner4.setAddress("Kastorias 1");
		propertyOwner4.setEmail("nikos@mail.com");
		propertyOwner4.setUsername("nnik");
		propertyOwner4.setPassward("1263");
		propertyOwnerService.addPropertyOwner(propertyOwner4);
		
		/*-----------------------OWNER5-------------------------*/
		PropertyOwner propertyOwner5 = new PropertyOwner();
		propertyOwner5.setVatNumber("734");
		propertyOwner5.setFirstName("Maria");
		propertyOwner5.setSurname("Georgiou");
		propertyOwner5.setPhoneNumber("6970314234");
		propertyOwner5.setAddress("Agias Sofias 82");
		propertyOwner5.setEmail("Maria@mail.com");
		propertyOwner5.setUsername("GeoM");
		propertyOwner5.setPassward("634T456");
		propertyOwnerService.addPropertyOwner(propertyOwner5);
		
		
		/*-----------------------PROPERTIES-------------------------*/
		/*-----------------------PROPERTY1-------------------------*/
		Property property1 = new Property();
		property1.setPropertyAddress("Kalamaria 35");
		property1.setYearOfConstrucitonDate(new Date());
		property1.setPropertyType(PropertyType.APARTMENT_BUILDING.name());
		propertyService.addProperty(property1);
		
		/*-----------------------PROPERTY2-------------------------*/
		Property property2 = new Property();
		property2.setPropertyAddress("Thrakis 83");
		property2.setYearOfConstrucitonDate(new Date());
		property2.setPropertyType(PropertyType.DETACHED_HOUSE.name());
		propertyService.addProperty(property2);
		
		/*-----------------------PROPERTY3-------------------------*/
		Property property3 = new Property();
		property3.setPropertyAddress("Peristeriou 56");
		property3.setYearOfConstrucitonDate(new Date());
		property3.setPropertyType(PropertyType.MAISONETTE.name());
		propertyService.addProperty(property3);
		
		/*-----------------------PROPERTY4-------------------------*/
		Property property4 = new Property();
		property4.setPropertyAddress("Marousi 7");
		property4.setYearOfConstrucitonDate(new Date());
		property4.setPropertyType(PropertyType.APARTMENT_BUILDING.name());
		propertyService.addProperty(property1);
		
		/*-----------------------PROPERTY5-------------------------*/
		Property property5 = new Property();
		property5.setPropertyAddress("Kleitou 9");
		property5.setYearOfConstrucitonDate(new Date());
		property5.setPropertyType(PropertyType.APARTMENT_BUILDING.name());
		propertyService.addProperty(property5);
		
		
		/*-----------------------REPAIRS-------------------------*/
		
		/*-----------------------REPAIR1-------------------------*/
		
		PropertyRepair repair1 = new PropertyRepair();
		repair1.setDate(LocalDate.of(2019, 8, 19));
		repair1.setDescriptionShort("sort Description 1");
		repair1.setRepairType(RepairType.ELECTRICAL_WORK);
		repair1.setStatusType(StatusType.COMPLETE);
		repair1.setCost(new BigDecimal("632.5"));
		repair1.setPropertyOwner(propertyOwner1);
		repair1.setPorperty(property5);
		repair1.setDescriptionBig("big Description 1");
		propertyRepairService.addPropertyRepair(repair1);
		
		/*-----------------------REPAIR2-------------------------*/
		PropertyRepair repair2 = new PropertyRepair();
		repair2.setDate(LocalDate.of(2019, 8, 19));
		repair2.setDescriptionShort("sort Description 2");
		repair2.setRepairType(RepairType.FRAMES);
		repair2.setStatusType(StatusType.PENDING);
		repair2.setCost(new BigDecimal("642.2"));
		repair2.setPropertyOwner(propertyOwner5);
		repair2.setPorperty(property1);
		repair2.setDescriptionBig("big Description 2");
		propertyRepairService.addPropertyRepair(repair2);
		
		/*-----------------------REPAIR3-------------------------*/
		PropertyRepair repair3 = new PropertyRepair();
		repair3.setDate(LocalDate.of(2019, 9, 1));
		repair3.setDescriptionShort("sort Description 3");
		repair3.setRepairType(RepairType.PLUMBING);
		repair3.setStatusType(StatusType.IN_PROGRESS);
		repair3.setCost(new BigDecimal("982.2"));
		repair3.setPropertyOwner(propertyOwner1);
		repair3.setPorperty(property5);
		repair3.setDescriptionBig("big Description 3");
		propertyRepairService.addPropertyRepair(repair3);
		
		/*-----------------------REPAIR4-------------------------*/
		PropertyRepair repair4 = new PropertyRepair();
		repair4.setDate(LocalDate.of(2019, 10, 23));
		repair4.setDescriptionShort("sort Description 4");
		repair4.setRepairType(RepairType.PLUMBING);
		repair4.setStatusType(StatusType.IN_PROGRESS);
		repair4.setCost(new BigDecimal("1022.2"));
		repair4.setPropertyOwner(propertyOwner1);
		repair4.setPorperty(property3);
		repair4.setDescriptionBig("big Description 4");
		propertyRepairService.addPropertyRepair(repair4);
		
		/*-----------------------REPAIR5-------------------------*/
		PropertyRepair repair5 = new PropertyRepair();
		repair5.setDate(LocalDate.of(2014, 9, 1));
		repair5.setDescriptionShort("sort Description 5");
		repair5.setRepairType(RepairType.PAINTING);
		repair5.setStatusType(StatusType.IN_PROGRESS);
		repair5.setCost(new BigDecimal("122.6"));
		repair5.setPropertyOwner(propertyOwner2);
		repair5.setPorperty(property3);
		repair5.setDescriptionBig("big Description 5");
		propertyRepairService.addPropertyRepair(repair5);
		
		
		
		
		
		/*-----------------------OWNER TEST-------------------------*/
		System.out.println("-----------------------OWNER TEST-------------------------");
		System.out.println("All the Property Owners inside DB are: ");
        System.out.println("----------------------------------------");
        propertyOwnerService.displayPropertyOwners();
        
        System.out.println("\nUpdate Owners address method called (update record 1 email to aggelos@mail.com)");
        propertyOwnerService.updateOwnersEmail(1, "NEWMAIL@mail.com");
        System.out.println("All the Property Owners inside DB are: ");
        System.out.println("---------------------------------------");
        propertyOwnerService.displayPropertyOwners();
        
        
        System.out.println("\nDelete Method Called:");
        propertyOwnerService.deletePropertyOwner(2);
        System.out.println("All the Property Owners inside DB are: ");
        System.out.println("---------------------------------------");       
        propertyOwnerService.displayPropertyOwners();
        
        System.out.println("\nSearch method called for vatNumber (951)\nOutput is:");
        propertyOwnerService.searchByVat("951");
        System.out.println();
        
        
        /*-----------------------REPAIRS TESTS-------------------------*/
        
        System.out.println("-----------------------REPAIRS TESTS-------------------------\n");
        
		
		/*-----------------------SEARCH-------------------------*/
		
		/*-----------------------SEARCH WITH SPECIFIC DATE-------------------------*/
		System.out.println("-------------------------AT DATE " + LocalDate.of(2019, 8, 19)+ " THE REPARIS ARE----------------------------\n");
		for(PropertyRepair p: propertyRepairService.searchByDate(LocalDate.of(2019, 8, 19))) {
			System.out.println(p.toString());
			
			
	
		}
		
		/*-----------------------SEARCH WITH OWNER ID-------------------------*/
		System.out.println("\n-------------------------REPAIR FOR SINGLE USER----------------------------\n");
		System.out.println("FOR OWNER WITH ID: 1");
		for(PropertyRepair p: propertyRepairService.searchById(1)) {
			System.out.println(p.toString());
		}
		
		/*-----------------------SEARCH WITH DATE RANGE-------------------------*/		
		System.out.println("\n-------------------------FROM DATE: "+ LocalDate.of(2019, 8, 1) + " UNTIL DATE: " + LocalDate.of(2019, 10, 30) +" ----------------------------\n");
		for(PropertyRepair p: propertyRepairService.searchByDateRange(LocalDate.of(2019, 8, 1), LocalDate.of(2019, 10, 30))) {
			System.out.println(p.toString());
		}
		
		
		/*-----------------------PROPERTY TESTS-------------------------*/
        
        System.out.println("-----------------------PROPERTY TESTS-------------------------\n");
		System.out.println("All the Properties inside DB are: ");
        System.out.println("----------------------------------");
        propertyService.displayProperties();
        
        System.out.println("\nUpdate Property address to NEW ADDRESS");
        propertyService.updatePropertyAddress(3, "NEW ADDRESS");
        System.out.println("All the Properties inside DB are: ");
        System.out.println("---------------------------------------");
        propertyService.displayProperties();
		
		
        System.out.println("\nDelete Property:");
        propertyService.deleteProperty(2);
        System.out.println("All the Properties inside DB are: ");
        System.out.println("---------------------------------------");       
        propertyService.displayProperties();
		
		
		
		
		
		
	}

}
