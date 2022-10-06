package com.bootcampEuroDyn.technikon.repository;

import java.util.Optional;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;

/**
 * Interface containing the update functions of the PropertyOwner model Class.
 * This interface extends the methods from the generic type interface repository
 */
public interface PropertyOwnerRepository extends Repository<PropertyOwner, Long> {

	boolean updateProperyOwnerAddress(long properyOwnerId, String newAddress);

	boolean updateProperyOwnerEmail(long properyOwnerId, String newEmail);

	boolean updateProperyOwnerPassword(long id, String newPassword);
	
	Optional<PropertyOwner> searchByVatNumber(String vatNumber);
	
	Optional<PropertyOwner> searchByEmail(String email);
	
}
