package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.model.PropertyFunctionalities;
import com.bootcampEuroDyn.technikon.repository.PropertyFunctionalitiesRepository;

public class PropertyFunctionalitiesImpl implements PropertyFunctionalitiesRepository{

	@Override
	public Optional<PropertyFunctionalities> add(PropertyFunctionalities t) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<PropertyFunctionalities> read(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PropertyFunctionalities> read(Long tId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean delete(Long tId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProperyFunctionalityAddress(long properyOwnerId, String newAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProperyFunctionalityYearOfConstructionDate(long properyOwnerId,
			String newYearOfConstructiongDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProperyFunctionalityPropertyType(long id, String newPropertyType) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
