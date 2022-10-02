package com.bootcampEuroDyn.technikon.domain;

import java.util.Date;

@Entity
public class PropertyFunctionalities implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id",unique = true, updatable= false, nullable =false)
	private String propertyId;
	@Column(name="propertyAddress", nullable = false)
	private String propertyAddress;
	@Column(name="yearOfConstructionDate", nullable = false)
	private Date yearOfConstrucitonDate;
	@Column(name="vatNumber", nullable = false)
	private String vatNumber;
	@Column(name="propertyTypeww", nullable = false)
	private PropertyType propertyType;
	private boolean deleted = Boolean.FALSE;
	
	@OneToMany(mappedBy="propertyFunctionalities")
	public PropertyFunctionalities(String propertyId, String propertyAddress, Date yearOfConstrucitonDate,
			String vatNumber, PropertyType propertyType) {
	
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
