package com.bootcampEuroDyn.technikon.domain;

import java.util.Date;


public class PropertyFunctionalities {
	private String propertyId;
	private String propertyAddress;
	private Date yearOfConstrucitonDate;
	private String vatNumber;
	private PropertyType propertyType;
	
	public PropertyFunctionalities(String propertyId, String propertyAddress, Date yearOfConstrucitonDate,
			String vatNumber, PropertyType propertyType) {
		super();
		this.propertyId = propertyId;
		this.propertyAddress = propertyAddress;
		this.yearOfConstrucitonDate = yearOfConstrucitonDate;
		this.vatNumber = vatNumber;
		this.propertyType = propertyType;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
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
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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
				+ ", yearOfConstrucitonDate=" + yearOfConstrucitonDate + ", vatNumber=" + vatNumber + ", propertyType="
				+ propertyType + "]";
	}
	
	

}
