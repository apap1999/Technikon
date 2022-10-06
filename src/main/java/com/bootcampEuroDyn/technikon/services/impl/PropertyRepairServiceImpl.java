package com.bootcampEuroDyn.technikon.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.services.PropertyRepairService;



public class PropertyRepairServiceImpl implements PropertyRepairService {
	
	private PropertyRepairRepository propertyRepairRepository;
	
	

	public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository) {
		
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
	public void updateDescriptioShort(long id, String newDescription) {
		propertyRepairRepository.updatePropertyRepairDescriptioShort(id, newDescription);
		
	}

	@Override
	public void updateDate(long repairID, Date newDate) {
		propertyRepairRepository.updatePropertyRepairDate(repairID, newDate);
		
	}

	@Override
	public void updateType(long repairID, RepairType newType) {
		propertyRepairRepository.updatePropertyRepairType(repairID, newType);
		
	}

	@Override
	public void updateStatus(long repairID, StatusType newStatus) {
		propertyRepairRepository.updatePropertyRepairStatus(repairID, newStatus);
		
	}

	@Override
	public void updateCost(long repairID, BigDecimal newCost) {
		propertyRepairRepository.updatePropertyRepairCost(repairID, newCost);
		
	}

	@Override
	public void updateOwner(long repairID, PropertyOwner newOwner) {
		propertyRepairRepository.updatePropertyRepairOwner(repairID, newOwner);
		
	}

	@Override
	public void updateDescriptioBig(long repairID, String newDescription) {
		propertyRepairRepository.updatePropertyRepairDescriptioBig(repairID, newDescription);
		
	}

	

	

	

}
