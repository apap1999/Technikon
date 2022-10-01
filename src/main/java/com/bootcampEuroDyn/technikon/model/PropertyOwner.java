package com.bootcampEuroDyn.technikon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="property_owners")
@SQLDelete(sql = "UPDATE property_owners SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted=false")
public class PropertyOwner implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="_id", unique = true, updatable = false, nullable = false)
	private long id;
	@Column(name="vatNumber", nullable = false)
	private String vatNumber;
	@Column(name="firstName", nullable = false)
	private String firstName;
	@Column(name="surname", nullable = false)
	private String surname;
	@Column(name="phoneNumber", nullable = false)
	private String phoneNumber;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="user", nullable = false)
	private String username;
	@Column(name="password", nullable = false)
	private String passward;
	private boolean deleted = Boolean.FALSE;

	public PropertyOwner() {}
	
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
