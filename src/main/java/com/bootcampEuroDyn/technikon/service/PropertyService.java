package com.bootcampEuroDyn.technikon.service;

import java.util.List;

import com.bootcampEuroDyn.technikon.exceptions.IsValidProperty;
import com.bootcampEuroDyn.technikon.model.Property;

public interface PropertyService{

	void addProperty(Property property);
	List<Property> displayProperties();
	List<Property> searchPropertyFunctionalities(long id) throws IsValidProperty ;
	void updatePropertyAddress(int id, String address);
	boolean deleteProperty(long i);
	void searchByVat(String string);
}
