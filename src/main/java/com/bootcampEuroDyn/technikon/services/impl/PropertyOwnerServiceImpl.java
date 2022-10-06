package com.bootcampEuroDyn.technikon.services.impl;

import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;
import com.bootcampEuroDyn.technikon.model.PropertyOwner;
import com.bootcampEuroDyn.technikon.repository.PropertyOwnerRepository;
import com.bootcampEuroDyn.technikon.services.PropertyOwnerService;

/**
 * This class contains the implementation of the PropertyOwnerService methods
 * (Business requirements). Property Owner Repository is injected to the
 * constructor. Methods call the repository methods passing parameters to do the
 * job.
 */
public class PropertyOwnerServiceImpl implements PropertyOwnerService {

	private PropertyOwnerRepository propertyOwnerRepo;

	public PropertyOwnerServiceImpl(PropertyOwnerRepository propertyOwnerRepo) {
		this.propertyOwnerRepo = propertyOwnerRepo;
	}

	public void addPropertyOwner(String vatNumber, String firstName, String surname, String phoneNumber, String email,
			String address, String username, String passwords) throws IsValidPropertyOwner {

		PropertyOwner propertyOwner = new PropertyOwner();
		propertyOwner.setVatNumber(vatNumber);
		propertyOwner.setFirstName(firstName);
		propertyOwner.setSurname(surname);
		propertyOwner.setPhoneNumber(phoneNumber);
		propertyOwner.setAddress(address);
		propertyOwner.setEmail(email);
		propertyOwner.setUsername(username);
		propertyOwner.setPassward(passwords);
		propertyOwner.setDeleted(false);
		Optional<PropertyOwner> propertyOptional = propertyOwnerRepo.add(propertyOwner);
		if (propertyOptional.isEmpty()) {
			throw new IsValidPropertyOwner("The owner has not been saved");
		}
	}

	public List<PropertyOwner> displayPropertyOwners() {
		return propertyOwnerRepo.read(1, 10); // default 10 elements per page
	}

	public List<PropertyOwner> dispLayPropertyOwner(long id) throws IsValidPropertyOwner {
		Optional<PropertyOwner> propertyOptional = propertyOwnerRepo.read(id);
		if (propertyOptional.isEmpty()) {
			throw new IsValidPropertyOwner("The owner has not been found");
		}
		return propertyOptional.stream().toList();
	}

	public void updateOwnersEmail(long id, String newEmail) {
		propertyOwnerRepo.updateProperyOwnerEmail(id, newEmail);
	}

	public void updateOwnersAddress(long id, String newAddress) {
		propertyOwnerRepo.updateProperyOwnerAddress(id, newAddress);
	}

	public void updateOwnersPassword(long id, String newPassword) {
		propertyOwnerRepo.updateProperyOwnerPassword(id, newPassword);
	}

	public void searchByVat(String vat) {
		propertyOwnerRepo.searchByVatNumber(vat);
	}

	public void searchByEmail(String email) {
		propertyOwnerRepo.searchByEmail(email);
	}

	public void deletePropertyOwner(long id) {
		propertyOwnerRepo.delete(id);
	}
}
