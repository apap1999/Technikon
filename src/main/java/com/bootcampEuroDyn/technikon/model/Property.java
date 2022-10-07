package com.bootcampEuroDyn.technikon.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "property")
@SQLDelete(sql = "UPDATE property SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted=false")
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private long propertyId;
	@Column(name = "propertyAddress", nullable = false)
	private String propertyAddress;
	@Column(name = "yearOfConstructionDate", nullable = false)
	private Date yearOfConstrucitonDate;
//	private String OwnersVatNumber;
	@Column(name = "propertyType", nullable = false)
	private String propertyType;
	private boolean deleted = Boolean.FALSE;

	@ManyToOne
	private PropertyOwner propertyOwner;
	
	@OneToMany(mappedBy = "porperty")
	private List<PropertyRepair> repairs;

	public Property() {
	}

	public Property(String propertyAddress, Date yearOfConstrucitonDate,
			 String propertyType) {

		this.propertyAddress = propertyAddress;
		this.yearOfConstrucitonDate = yearOfConstrucitonDate;
//		this.OwnersVatNumber = OwnersVatNumber;
		this.propertyType = propertyType;
	}

}
