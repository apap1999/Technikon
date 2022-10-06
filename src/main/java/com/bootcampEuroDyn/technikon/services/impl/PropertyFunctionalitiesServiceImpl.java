package com.bootcampEuroDyn.technikon.services.impl;

import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;
import com.bootcampEuroDyn.technikon.repository.PropertyFunctionalitiesRepository;
import com.bootcampEuroDyn.technikon.services.PropertyFunctionalitiesService;

public class PropertyFunctionalitiesServiceImpl implements PropertyFunctionalitiesService {
	private PropertyFunctionalitiesRepository propertyFunctionalitiesRepository;

	public PropertyFunctionalitiesServiceImpl(PropertyFunctionalitiesRepository propertyFunctionalitiesRepository) {

		this.propertyFunctionalitiesRepository = propertyFunctionalitiesRepository;
	}

	@Override
	public void addPropertyFunctionalities(PropertyFunctionalities propertyFunctionalities) {
		Optional<PropertyFunctionalities> propertyDB = propertyFunctionalitiesRepository.add(propertyFunctionalities);

		if (propertyDB.isEmpty())
			System.out.println("Functionality has not been saved");

	}

	@Override
	public List<PropertyFunctionalities> displayPropertyFunctionalities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyFunctionalities searchPropertyFunctionalities(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
