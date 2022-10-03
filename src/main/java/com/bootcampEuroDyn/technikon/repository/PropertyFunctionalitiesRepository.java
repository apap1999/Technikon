package com.bootcampEuroDyn.technikon.repository;

import java.util.List;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;

public interface PropertyFunctionalitiesRepository {
	 boolean createPropertyFunctionalities (PropertyFunctionalities propertyFunctionalities);
     List<PropertyFunctionalities> readPropertyFunctionalities();
     PropertyFunctionalities readPropertyFunctionalities(String propertyId);
     
     boolean deletePropertyFunctionalities(String propertyId);
}
