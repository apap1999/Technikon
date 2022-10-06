package com.bootcampEuroDyn.technikon;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
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

		propertyOwnerService.addPropertyOwner("123", "Angelos", "Tsaousis", "69696969", "Greece", "agg@mail.com",
				"swolf", "123456");
		propertyOwnerService.addPropertyOwner("311", "Nick", "Petrou", "6969653242969", "Greece", "pet@mail.com",
				"retewr", "243652346");
		propertyOwnerService.displayPropertyOwners();
		propertyOwnerService.updateOwnersAddress(1, "UK");
		propertyOwnerService.displayPropertyOwners();
		propertyOwnerService.deletePropertyOwner(2);
		propertyOwnerService.displayPropertyOwners();
		propertyOwnerService.searchByVat("123");

//		PropertyRepair repair = new PropertyRepair();
//		repair.setDate(new Date());
//		repair.setDescriptionShort("sort test");
//		repair.setRepairType(RepairType.ELECTRICAL_WORK);
//		repair.setStatusType(StatusType.COMPLETE);
//		repair.setCost(new BigDecimal("632.5"));
//		repair.setPropertyOwner(propertyOwner);
//		repair.setPropertyID(22);
//		repair.setDescriptionBig("big test");
//		propertyRepairService.addPropertyRepair(repair);
//;
//		
//		
//		PropertyRepair repair2 = new PropertyRepair();
//		repair2.setDate(new Date());
//		repair2.setDescriptionShort("sort test2");
//		repair2.setRepairType(RepairType.FRAMES);
//		repair2.setStatusType(StatusType.IN_PROGRESS);
//		repair2.setCost(new BigDecimal("412.5"));
//		repair2.setPropertyOwner(propertyOwner2);
//		repair2.setPropertyID(54);
//		repair2.setDescriptionBig("big test2");
//		propertyRepairService.addPropertyRepair(repair2);

//		System.out.println("-----------------------------------------------------");
//		System.out.println(propertyRepairService.searchPropertyRepair(2).getPropertyOwner().getFirstName());
//		System.out.println("-----------------------------------------------------");

		JPAUtil.shutdown();

	}

}
