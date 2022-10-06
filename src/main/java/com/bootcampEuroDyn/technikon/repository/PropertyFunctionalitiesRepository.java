package com.bootcampEuroDyn.technikon.repository;

import java.util.Date;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;

public interface PropertyFunctionalitiesRepository extends Repository<PropertyFunctionalities, Long> {
	boolean updatePropertyFunctionalityAddress(long propertyFunctionalityId, String newAddress);

	boolean updatePropertyFunctionalityYearOfConstructionDate(long propertyFunctionalityId,
			Date newYearOfConstructiongDate);

	boolean updatePropertyFunctionalityPropertyType(long id, String newPropertyType);
}
