package com.bootcampEuroDyn.technikon.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.bootcampEuroDyn.technikon.domain.RepairType;
import com.bootcampEuroDyn.technikon.domain.StatusType;





@Entity

public class PropertyRepair {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private Date date;
	private String descriptionShort;
	private RepairType repairType;
	private StatusType statusType;
	private BigDecimal cost;
	
	
//	@ManyToOne
//	private PropertyOwner propertyOwner;
//	private long propertyID;
//	private String descriptionBig;
//
//	@ManyToOne
//	private PropertyFunctionalities propertyFunctionalities;
	
	
	public long getId() {
		return id;

	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescriptionShort() {
		return descriptionShort;
	}
	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}
	public RepairType getRepairType() {
		return repairType;
	}
	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}
	public StatusType getStatusType() {
		return statusType;
	}
	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


}
