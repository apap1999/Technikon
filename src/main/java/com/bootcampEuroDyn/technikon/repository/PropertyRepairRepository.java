package com.bootcampEuroDyn.technikon.repository;

import java.math.BigDecimal;
import java.util.Date;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;

public interface PropertyRepairRepository extends Repository<PropertyRepair, Long>{
	
	void updatePropertyRepairDate(long repairID,Date newDate);
	void updatePropertyRepairDescriptioShort(long repairID,String newDescription);
	void updatePropertyRepairType(long repairID,RepairType newType);
	void updatePropertyRepairStatus(long repairID,StatusType newStatus);
	void updatePropertyRepairCost(long repairID,BigDecimal newCost);
	void updatePropertyRepairOwner(long repairID,PropertyOwner newOwner);
	void updatePropertyRepairDescriptioBig(long repairID,String newDescription);
	
	
	
	
	
	

}
