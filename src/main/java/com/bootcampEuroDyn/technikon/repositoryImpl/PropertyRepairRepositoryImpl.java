package com.bootcampEuroDyn.technikon.repositoryImpl;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair, Long> 
implements PropertyRepairRepository{
	
	

	public PropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {
		
		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {
		return PropertyRepair.class;
	}

	@Override
	public void updatePropertyRepairDescriptioShort(long repairID, String newDescription) {
		
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setDescriptionShort(newDescription);
		finishEntity(repair);
		
	}

	@Override
	public void updatePropertyRepairDate(long repairID, Date newDate) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setDate(newDate);
		finishEntity(repair);
		
	}

	@Override
	public void updatePropertyRepairType(long repairID, RepairType newType) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setRepairType(newType);
		finishEntity(repair);
	}

	@Override
	public void updatePropertyRepairStatus(long repairID, StatusType newStatus) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setStatusType(newStatus);
		finishEntity(repair);
	}

	@Override
	public void updatePropertyRepairCost(long repairID, BigDecimal newCost) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setCost(newCost);
		finishEntity(repair);
	}

	@Override
	public void updatePropertyRepairOwner(long repairID, PropertyOwner newOwner) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setPropertyOwner(newOwner);
		finishEntity(repair);
	}

	@Override
	public void updatePropertyRepairDescriptioBig(long repairID, String newDescription) {
		PropertyRepair repair = getRepairAndStartTransaction(repairID);
		repair.setDescriptionBig(newDescription);
		finishEntity(repair);
	}
	
	
	private PropertyRepair getRepairAndStartTransaction(long repairID) {
		super.entityManager.getTransaction().begin();
		PropertyRepair repair = super.read(repairID).get();
		return repair;
	}
	
	private void finishEntity(PropertyRepair repair) {
		super.entityManager.persist(repair);
		super.entityManager.getTransaction().commit();
	}

	
	

	
}
