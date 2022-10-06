package com.bootcampEuroDyn.technikon.services;

import java.util.List;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;

/**
 * Interface of the Property Owner in the Service layer. It contains all the
 * business methods ADD-READ-UPDATE-SEARCH-DELETE.
 */
public interface PropertyOwnerService {

	void addPropertyOwner(String vatNumber, String firstName, String surname, String phoneNumber, String email,
			String address, String username, String passwords) throws IsValidPropertyOwner;

	public List<PropertyOwner> displayPropertyOwners();

	List<PropertyOwner> dispLayPropertyOwner(long id) throws IsValidPropertyOwner;

	void updateOwnersEmail(long id, String newEmail);

	void updateOwnersAddress(long id, String newAddress);

	void updateOwnersPassword(long id, String newPassword);

	void searchByVat(String vat);

	void searchByEmail(String email);

	void deletePropertyOwner(long id);
}
