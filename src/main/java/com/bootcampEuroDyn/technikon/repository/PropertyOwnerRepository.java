package com.bootcampEuroDyn.technikon.repository;

import com.bootcampEuroDyn.technikon.model.PropertyOwner;

public interface PropertyOwnerRepository extends Repository<PropertyOwner, Long>{
	
	boolean updateProperyOwnerAddress(long properyOwnerId, String newAddress);
	boolean updateProperyOwnerEmail(long properyOwnerId, String newEmail);
	boolean updateProperyOwnerPassword(long id, String newPassword);

}
