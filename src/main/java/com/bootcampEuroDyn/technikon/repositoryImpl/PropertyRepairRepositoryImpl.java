package com.bootcampEuroDyn.technikon.repositoryImpl;


import javax.persistence.EntityManager;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair, Long> 
implements PropertyRepairRepository{
	
	

	public PropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {
		
		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {
		return PropertyRepair.class;
	}

	
	

	
}
