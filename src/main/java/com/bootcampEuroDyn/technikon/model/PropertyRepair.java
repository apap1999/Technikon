package com.bootcampEuroDyn.technikon.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bootcampEuroDyn.technikon.model.enumeration.RepairType;
import com.bootcampEuroDyn.technikon.model.enumeration.StatusType;

@Entity
public class PropertyRepair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate date;
	private String descriptionShort;
	private RepairType repairType;
	private StatusType statusType;
	private BigDecimal cost;
	private String descriptionBig;
	@ManyToOne
	private PropertyOwner propertyOwner;
	@ManyToOne
	private Property porperty;
	
	
	
	
	public Property getPorperty() {
		return porperty;
	}
	public void setPorperty(Property porperty) {
		this.porperty = porperty;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
	
	public String getDescriptionBig() {
		return descriptionBig;
	}
	public void setDescriptionBig(String descriptionBig) {
		this.descriptionBig = descriptionBig;
	}
	public PropertyOwner getPropertyOwner() {
		return propertyOwner;
	}
	public void setPropertyOwner(PropertyOwner propertyOwner) {
		this.propertyOwner = propertyOwner;
	}
	
	@Override
	public String toString() {
		return "{id=" + id + ", date=" + date + ", descriptionShort=" + descriptionShort
				+ ", repairType=" + repairType + ", statusType=" + statusType + ", cost=" + cost + ", descriptionBig="
				+ descriptionBig + ", propertyOwner=" + propertyOwner + ", porperty=" + porperty + "}";
	}
	
	
	

	


}
