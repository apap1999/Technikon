package com.bootcampEuroDyn.technikon.service;

import java.util.List;

import com.bootcampEuroDyn.technikon.exceptions.IsValidProperty;
import com.bootcampEuroDyn.technikon.model.Property;

public interface PropertyService{

	void addProperty(Property property);
	List<Property> displayPropertyFunctionalities();
	List<Property> searchPropertyFunctionalities(long id) throws IsValidProperty ;
	void updatePropertyFunctionalityAddress(int i, String string);
	void deleteProperty(int i);
	void searchByVat(String string);
}
