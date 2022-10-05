package com.bootcampEuroDyn.technikon.services.impl;

import java.util.List;
import java.util.Optional;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.repository.Repository;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;



public class PropertyRepairServiceImpl implements PropertyRepairService {
	
	private Repository<PropertyRepair, Long> propertyRepairRepository;
	
	public PropertyRepairServiceImpl(Repository<PropertyRepair, Long> propertyRepairRepository) {
		this.propertyRepairRepository = propertyRepairRepository;
	}

	@Override
	public void addPropertyRepair(PropertyRepair ropertyRepair) {
		Optional<PropertyRepair> propertyRepairDB = propertyRepairRepository.add(ropertyRepair);
		
		if(propertyRepairDB.isEmpty())
			System.out.println("Repair has not been saved");
		
	}

	@Override
	public List<PropertyRepair> displayPropertyRepair() {
		return propertyRepairRepository.read(1, 20);
	}

	@Override
	public PropertyRepair searchPropertyRepair(long id) {
		
		Optional<PropertyRepair> pr = propertyRepairRepository.read(id);
		
		return pr.get();
	}

	

	

}
