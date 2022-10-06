package com.bootcampEuroDyn.technikon.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;


public class PropertyOwnerServiceImpl {
	
	private Repository<PropertyOwner, Long> propertyOwnerRepo;
	
	public PropertyOwnerServiceImpl(Repository<PropertyOwner, Long> propertyOwnerRepo) {
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
	
	public Optional<PropertyOwner> dispLayPropertyOwner(long id) throws IsValidPropertyOwner{
		Optional<PropertyOwner> propertOptional = propertyOwnerRepo.read(id);
		if(propertOptional.isEmpty()) {
			throw new IsValidPropertyOwner("The owner has not been found");
		}
		return propertOptional;
	}
	
	public List<PropertyOwner> searchByVat(String vat) {
		return displayPropertyOwners().stream().filter(o->o.getVatNumber().equals(vat)).collect(Collectors.toList());
	}
	
	public List<PropertyOwner> searchByEmail(String email) {
		return displayPropertyOwners().stream().filter(o->o.getEmail() == email ).collect(Collectors.toList());
	}
	
	public void deletePropertyOwner(long id) {
		propertyOwnerRepo.delete(id);
	}
	
	
}
