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
		
	}

}
