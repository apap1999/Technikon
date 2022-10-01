package com.bootcampEuroDyn.technikon.model;

import java.util.Date;

public class PropertyFunctionalities{
	
	
	private long propertyId;
	private String propertyAddress;
	private Date yearOfConstrucitonDate;	
	private PropertyType propertyType;
	private String OwnersVatNumber;
	
	public PropertyFunctionalities(long propertyId, String propertyAddress, Date yearOfConstrucitonDate,
			String OwnersVatNumber, PropertyType propertyType) {
		this.propertyId = propertyId;
		this.propertyAddress = propertyAddress;
		this.yearOfConstrucitonDate = yearOfConstrucitonDate;
		this.OwnersVatNumber = OwnersVatNumber;
		this.propertyType = propertyType;
	}
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
