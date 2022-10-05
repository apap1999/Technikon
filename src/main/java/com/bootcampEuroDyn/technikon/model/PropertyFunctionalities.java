package com.bootcampEuroDyn.technikon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bootcampEuroDyn.technikon.domain.PropertyType;



@Entity
public class PropertyFunctionalities implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id",unique = true, updatable= false, nullable =false)
	private long propertyId;
	@Column(name="propertyAddress", nullable = false)
	private String propertyAddress;
	@Column(name="yearOfConstructionDate", nullable = false)
	private Date yearOfConstrucitonDate;
	@Column(name="OwnersVatNumber", nullable = false)
	private String OwnersVatNumber;
	@Column(name="propertyType", nullable = false)
	private PropertyType propertyType;
	private boolean deleted = Boolean.FALSE;
	
	@ManyToOne
	private PropertyOwner propertyOwner;

	//@OneToMany(mappedBy="propertyFunctionalities")
	
	public PropertyFunctionalities(){}
	
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

