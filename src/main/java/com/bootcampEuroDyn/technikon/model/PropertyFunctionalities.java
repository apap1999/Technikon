package com.bootcampEuroDyn.technikon.model;




import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.bootcampEuroDyn.technikon.model.enumeration.PropertyType;


@Entity
public class PropertyFunctionalities  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long propertyId;
	private String propertyAddress;
	private Date yearOfConstrucitonDate;
	private String OwnersVatNumber;
	private PropertyType propertyType;
	private boolean deleted = Boolean.FALSE;
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
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
	public String getOwnersVatNumber() {
		return OwnersVatNumber;
	}
	public void setOwnersVatNumber(String ownersVatNumber) {
		OwnersVatNumber = ownersVatNumber;
	}
	public PropertyType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
