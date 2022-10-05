package com.bootcampEuroDyn.technikon.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ManyToOne;

public class PropertyRepair {
	
	private Date date;
	private String descriptionShort;
	private RepairType repairType;
	private StatusType statusType;
	private BigDecimal cost;
	private long ownerID;
	private long propertyID;
	private String descriptionBig;
	@ManyToOne
	private PropertyFunctionalities propertyFunctionalities;
	
	public PropertyRepair(Date date, String descriptionShort, RepairType repairType, StatusType statusType,
			BigDecimal cost, long ownerID, long propertyID, String descriptionBig) {
		
		this.date = date;
		this.descriptionShort = descriptionShort;
		this.repairType = repairType;
		this.statusType = statusType;
		this.cost = cost;
		this.ownerID = ownerID;
		this.propertyID = propertyID;
		this.descriptionBig = descriptionBig;
	}

	public PropertyRepair() {
		
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

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public long getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}

	public String getDescriptionBig() {
		return descriptionBig;
	}

	public void setDescriptionBig(String descriptionBig) {
		this.descriptionBig = descriptionBig;
	}

	@Override
	public String toString() {
		return "PropertyRepair [date=" + date + ", descriptionShort=" + descriptionShort + ", repairType=" + repairType
				+ ", statusType=" + statusType + ", cost=" + cost + ", ownerID=" + ownerID + ", propertyID="
				+ propertyID + ", descriptionBig=" + descriptionBig + "]";
	}
	
	

}
