package com.bootcampEuroDyn.technikon.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model Class Property Owner contains the needed attributes of an owner.
 * Attributes will be stored on a database with Hibernate. Hibernate will make
 * the connection and create the table property_owners with the specified
 * attributes as columns.
 * 
 * @SQLDelete and @Where annotations will help us handle deletions on the
 *            database.
 * @Getters @Setters and @ToString are generated through Lombok.
 * 
 * @author Marougkas Orfeas
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "property_owners")
@SQLDelete(sql = "UPDATE property_owners SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted=false")
public class PropertyOwner implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, updatable = false, nullable = false)
	private long id;
	@Column(name = "vatNumber", nullable = false)
	private String vatNumber;
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "user", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String passward;
	/*
	 * This attribute will help us to keep the deleted records on the database
	 * (safely deleted records)
	 */
	private boolean deleted = Boolean.FALSE;

	/*
	 * Foreign Keys - Relation with the other Tables
	 */
	@OneToMany(mappedBy = "propertyOwner")
	private List<Property> properties;

	@OneToMany(mappedBy = "propertyOwner")
	private List<PropertyRepair> repairs;

	/*
	 * Constructors
	 */

	public PropertyOwner() {
	}

	public PropertyOwner(String vatNumber, String firstName, String surname, String phoneNumber, String email,
			String username, String passward) {
		this.vatNumber = vatNumber;
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.passward = passward;
	}
}