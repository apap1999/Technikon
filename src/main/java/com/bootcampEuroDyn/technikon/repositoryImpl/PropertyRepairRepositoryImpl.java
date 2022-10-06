package com.bootcampEuroDyn.technikon.repositoryImpl;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyRepair;
import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.repository.PropertyRepairRepository;
import com.bootcampEuroDyn.technikon.service.impl.PropertyOwnerServiceImpl;
import com.bootcampEuroDyn.technikon.utility.JPAUtil;

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
	public void updatePropertyRepairDate(long repairID, LocalDate newDate) {
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

	@Override
	public List<PropertyRepair> searchRepairbyDate(LocalDate date) {
				
		String qString = "SELECT c FROM PropertyRepair c WHERE c.date = :_date";
		TypedQuery<PropertyRepair> tQuery = super.entityManager.createQuery(qString,PropertyRepair.class);
		tQuery.setParameter("_date", date);		
		return tQuery.getResultList();
	}
	
	
	@Override
	public List<PropertyRepair> searchRepairByDateRange(LocalDate fromDate, LocalDate toDate) {
		String qString = "SELECT c FROM PropertyRepair c WHERE c.date BETWEEN :_fromDate AND :_toDate";
		TypedQuery<PropertyRepair> tQuery = super.entityManager.createQuery(qString,PropertyRepair.class);
		tQuery.setParameter("_fromDate", fromDate);
		tQuery.setParameter("_toDate", toDate);
		return tQuery.getResultList();
	}

	@Override
	public List<PropertyRepair> searchRepairByUserId(long sId) {
		String qString = "SELECT c FROM PropertyOwner c WHERE c.id = :_id";
		TypedQuery<PropertyOwner> tQuery = super.entityManager.createQuery(qString,PropertyOwner.class);
		tQuery.setParameter("_id", sId);
		return tQuery.getSingleResult().getRepairs();
		
	}
	
	
	

	

	

	

	
	

	
}
