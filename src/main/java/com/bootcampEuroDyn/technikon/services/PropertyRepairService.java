package com.bootcampEuroDyn.technikon.services;

import java.util.List;

import com.bootcampEuroDyn.technikon.model.PropertyRepair;

public interface PropertyRepairService {
	
	void addPropertyRepair(PropertyRepair ropertyRepair);
	List<PropertyRepair> displayPropertyRepair();
	PropertyRepair searchPropertyRepair(long id);
	
}
