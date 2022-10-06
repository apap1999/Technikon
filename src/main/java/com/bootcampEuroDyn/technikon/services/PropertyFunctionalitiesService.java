package com.bootcampEuroDyn.technikon.services;

import java.util.List;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;

public interface PropertyFunctionalitiesService{

	void addPropertyFunctionalities(PropertyFunctionalities propertyFunctionalities);
	List<PropertyFunctionalities> displayPropertyFunctionalities();
	PropertyFunctionalities searchPropertyFunctionalities(long id);
}
