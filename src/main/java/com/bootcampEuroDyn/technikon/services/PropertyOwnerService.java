package com.bootcampEuroDyn.technikon.services;

import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.Repository;


public class PropertyOwnerService {
	
	private Repository<PropertyOwner, Long> propertyOwnerRepo;
	
	public PropertyOwnerService(Repository<PropertyOwner, Long> propertyOwnerRepo) {
		this.propertyOwnerRepo = propertyOwnerRepo;
	}
	
	public void addPropertyOwner(PropertyOwner propertyOwner) throws IsValidPropertyOwner {
		Optional<PropertyOwner> propertOptional = propertyOwnerRepo.add(propertyOwner);
		if(propertOptional.isEmpty()) {
			throw new IsValidPropertyOwner("The owner has not been saved");
		}
	}
	
	public List<PropertyOwner> displayPropertyOwners(){
		return propertyOwnerRepo.read(1, 10); //default 10 elements per page
	}
	
	
	 
}
