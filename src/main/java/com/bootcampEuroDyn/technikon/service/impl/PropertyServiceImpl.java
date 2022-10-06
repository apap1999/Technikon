package com.bootcampEuroDyn.technikon.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.exceptions.IsValidProperty;
import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.Property;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.PropertyRepository;
import com.bootcampEuroDyn.technikon.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {
	private PropertyRepository propertyFunctionalitiesRepository;

	public PropertyServiceImpl(PropertyRepository propertyFunctionalitiesRepository) {

		this.propertyFunctionalitiesRepository = propertyFunctionalitiesRepository;
	}

	@Override
	public void addProperty(Property property){
		propertyFunctionalitiesRepository.add(property);
		
	}

	@Override
	public List<Property> displayPropertyFunctionalities() {
		return propertyFunctionalitiesRepository.read(1, 20);
	}
	public List<Property> searchPropertyFunctionalities(long id) throws IsValidProperty {
		Optional<Property> propertyOptional = propertyFunctionalitiesRepository.read(id);
		if (propertyOptional.isEmpty()) {
			throw new IsValidProperty("The property has not been found");
		}
		return propertyOptional.stream().toList();
	}
	
	public void updatePropertyAddress(long id, String Address) {
		propertyFunctionalitiesRepository.updatePropertyFunctionalityAddress(id, Address);
	}
	
	public void updatePropertyYearOfConstructionDate(long id, Date newYearOfConstructionDate) {
		propertyFunctionalitiesRepository.updatePropertyFunctionalityYearOfConstructionDate(id, newYearOfConstructionDate);
	}
	
	public void updatePropertyType(long id,String newPropertyType) {
		propertyFunctionalitiesRepository.updatePropertyFunctionalityPropertyType(id, newPropertyType);
	}
	
	public void deleteProperty(Long tId) {
		propertyFunctionalitiesRepository.delete(tId);
	}

	@Override
	public void updatePropertyFunctionalityAddress(int i, String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProperty(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchByVat(String string) {
		// TODO Auto-generated method stub
		
	}

}
