package com.bootcampEuroDyn.technikon.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;

public interface PropertyRepairService {
	
	void addPropertyRepair(PropertyRepair ropertyRepair);
	List<PropertyRepair> displayPropertyRepair();
	void updateDate(long repairID, LocalDate newDate);
	void updateDescriptioShort(long id,String newDescription);
	void updateType(long repairID,RepairType newType);
	void updateStatus(long repairID,StatusType newStatus);
	void updateCost(long repairID,BigDecimal newCost);
	void updateOwner(long repairID,PropertyOwner newOwner);
	void updateDescriptioBig(long repairID,String newDescription);
	List<PropertyRepair> searchByDate(LocalDate date);
	List<PropertyRepair> searchByDateRange(LocalDate fromDate, LocalDate toDate);
	List<PropertyRepair> searchById(long sId);
	
	
}
