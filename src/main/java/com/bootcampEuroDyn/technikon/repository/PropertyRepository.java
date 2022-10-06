package com.bootcampEuroDyn.technikon.repository;

import java.util.Date;

import com.bootcampEuroDyn.technikon.model.Property;

public interface PropertyRepository extends Repository<Property, Long> {
	boolean updatePropertyFunctionalityAddress(long propertyFunctionalityId, String newAddress);

	boolean updatePropertyFunctionalityYearOfConstructionDate(long propertyFunctionalityId,
			Date newYearOfConstructiongDate);

	boolean updatePropertyFunctionalityPropertyType(long id, String newPropertyType);
}
