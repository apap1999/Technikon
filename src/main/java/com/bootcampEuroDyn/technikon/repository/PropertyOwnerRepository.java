package com.bootcampEuroDyn.technikon.repository;



public interface PropertyOwnerRepository {
	
	void addPropertyOwner(String vatNumber, String firstName,
			String surname, String phoneNumber, String email, String username, String password);
	void getPropertyOwners();
	void getPropertyOwner(long id);
	void updateProperyOwnerAddress(long id, String address);
	void updateProperyOwnerEmail(String vatNumber, String email);
	void updateProperyOwnerPassword(long id, String password);
	void safelyDeletePropertyOwner(long id);
}
