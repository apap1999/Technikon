package com.bootcampEuroDyn.technikon;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.domain.PropertyType;
import com.bootcampEuroDyn.technikon.domain.RepairType;
import com.bootcampEuroDyn.technikon.domain.StatusType;
import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.repository.PropertyFunctionalitiesRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyFunctionalitiesImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;
import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyRepairRepositoryImpl;
import com.bootcampEuroDyn.technikon.services.PropertyFunctionalitiesService;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;
import com.bootcampEuroDyn.technikon.services.impl.PropertyFunctionalitiesServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.services.impl.PropertyRepairServiceImpl;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		PropertyFunctionalitiesRepository propertyFunctionalitiesRepository= new PropertyFunctionalitiesImpl(entityManager);
		PropertyFunctionalitiesService propertyFunctionalitiesService = new PropertyFunctionalitiesServiceImpl(propertyFunctionalitiesRepository);
		
		PropertyFunctionalities property = new PropertyFunctionalities();
		//property.setOwnersVatNumber("abc");
		property.setPropertyAddress("Zakynthou 26");
		property.setPropertyType(PropertyType.APARTMENT_BUILDING.name());
		property.setYearOfConstrucitonDate(new Date());
		propertyFunctionalitiesService.addPropertyFunctionalities(property);
		

		JPAUtil.shutdown();
		
	}

}
