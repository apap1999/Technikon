package com.bootcampEuroDyn.technikon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PropertyFunctionalities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long propertyId;
	private String propertyAddress;
	private Date yearOfConstrucitonDate;	
	private PropertyType propertyType;
	private String OwnersVatNumber;
	@ManyToOne
	private PropertyOwner propertyOwner;
	
	public PropertyFunctionalities(long propertyId, String propertyAddress, Date yearOfConstrucitonDate,
			String OwnersVatNumber, PropertyType propertyType) {
		this.propertyId = propertyId;
		this.propertyAddress = propertyAddress;
		this.yearOfConstrucitonDate = yearOfConstrucitonDate;
		this.OwnersVatNumber = OwnersVatNumber;
		this.propertyType = propertyType;
	}
	public PropertyFunctionalities() {}
	public long getPropertyId() {
		return propertyId;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public Date getYearOfConstrucitonDate() {
		return yearOfConstrucitonDate;
	}
	public void setYearOfConstrucitonDate(Date yearOfConstrucitonDate) {
		this.yearOfConstrucitonDate = yearOfConstrucitonDate;
	}
	public String getVatNumber() {
		return OwnersVatNumber;
	}
	public void setVatNumber(String OwnersVatNumber) {
		this.OwnersVatNumber = OwnersVatNumber;
	}
	public PropertyType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	@Override
	public String toString() {
		return "PropertyFunctionalities [propertyId=" + propertyId + ", propertyAddress=" + propertyAddress
				+ ", yearOfConstrucitonDate=" + yearOfConstrucitonDate + ", vatNumber=" + OwnersVatNumber + ", propertyType="
				+ propertyType + "]";
	}
	
	

}
