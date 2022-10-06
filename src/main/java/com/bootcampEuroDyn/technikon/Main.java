package com.bootcampEuroDyn.technikon;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepairRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;
import com.bootcampEuroDyn.technikon.services.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyRepairServiceImpl;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {

		EntityManager entityManager = JPAUtil.getEntityManager();

		PropertyOwnerRepository repository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(repository);

		Repository<PropertyRepair, Long> propertyRepaiRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepaiRepository);

		propertyOwnerService.addPropertyOwner("123456789", "Angelos", "Tsaousis", "696696969", "Greece", "agg@mail.com",
				"swolf", "123456");
		propertyOwnerService.addPropertyOwner("987654321", "Nick", "Petrou", "69653242969", "Greece", "nick@mail.com",
				"retewr", "243652346");
		propertyOwnerService.addPropertyOwner("139492148", "Orfeas", "Marougkas", "6984628359", "Greece", "orfeas@mail.com",
				"myUser", "orfeas");
		propertyOwnerService.addPropertyOwner("998317426", "kostas", "Papadopoulos", "69761492140", "Greece", "kostas@mail.com",
				"user123", "lol123");
		propertyOwnerService.addPropertyOwner("098136472", "Andreas", "Papadias", "69565324369", "Greece", "andreas@mail.com",
				"admin", "1234");
		System.out.println("All the Property Owners inside DB are: ");
		System.out.println("========================================");
		propertyOwnerService.displayPropertyOwners();
		System.out.println("\nUpdate Owners address method called (update record 1 email to aggelos@mail.com)");
		propertyOwnerService.updateOwnersEmail(1, "aggelos@mail.com");
		System.out.println("All the Property Owners inside DB are: ");
		System.out.println("========================================");
		propertyOwnerService.displayPropertyOwners();
		System.out.println("\nDelete Method Called:");
		propertyOwnerService.deletePropertyOwner(2);
		System.out.println("All the Property Owners inside DB are: ");
		System.out.println("========================================");
		propertyOwnerService.displayPropertyOwners();
		System.out.println("\nSearch method called for vatNumber (139492148)\nOutput is:");
		propertyOwnerService.searchByVat("139492148");

		PropertyRepair repair = new PropertyRepair();
		repair.setDate(new Date());
		repair.setDescriptionShort("sort test");
		repair.setRepairType(RepairType.ELECTRICAL_WORK);
		repair.setStatusType(StatusType.COMPLETE);
		repair.setCost(new BigDecimal("632.5"));
		//repair.setPropertyOwner(propertyOwner);
		repair.setPropertyID(22);
		repair.setDescriptionBig("big test");
		propertyRepairService.addPropertyRepair(repair);
//		
//		
		PropertyRepair repair2 = new PropertyRepair();
		repair2.setDate(new Date());
		repair2.setDescriptionShort("sort test2");
		repair2.setRepairType(RepairType.FRAMES);
		repair2.setStatusType(StatusType.IN_PROGRESS);
		repair2.setCost(new BigDecimal("412.5"));
		//repair2.setPropertyOwner(propertyOwner2);
		repair2.setPropertyID(54);
		repair2.setDescriptionBig("big test2");
		propertyRepairService.addPropertyRepair(repair2);

//		System.out.println("-----------------------------------------------------");
//		System.out.println(propertyRepairService.searchPropertyRepair(2).getPropertyOwner().getFirstName());
//		System.out.println("-----------------------------------------------------");

		JPAUtil.shutdown();

	}

}