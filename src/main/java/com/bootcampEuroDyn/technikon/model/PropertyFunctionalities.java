package com.bootcampEuroDyn.technikon.model;

import java.util.Date;

<<<<<<< HEAD:src/main/java/com/bootcampEuroDyn/technikon/domain/PropertyFunctionalities.java
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
	
=======
public class PropertyFunctionalities{
	
	
	private long propertyId;
	private String propertyAddress;
	private Date yearOfConstrucitonDate;	
	private PropertyType propertyType;
	private String OwnersVatNumber;
	
	public PropertyFunctionalities(long propertyId, String propertyAddress, Date yearOfConstrucitonDate,
			String OwnersVatNumber, PropertyType propertyType) {
>>>>>>> 92c4d579050416b3c1f5ae0c64b8a83648ce931b:src/main/java/com/bootcampEuroDyn/technikon/model/PropertyFunctionalities.java
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
