package com.bootcampEuroDyn.technikon.repository;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;

public interface PropertyFunctionalitiesRepository extends Repository<PropertyFunctionalities, Long> {
	boolean updateProperyFunctionalityAddress(long properyOwnerId, String newAddress);
	boolean updateProperyFunctionalityYearOfConstructionDate(long properyOwnerId, String newYearOfConstructiongDate);
	boolean updateProperyFunctionalityPropertyType(long id, String newPropertyType);
}
