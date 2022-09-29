package com.bootcamp.technikon;


import com.bootcamp.technikon.repository.PropertyOwnerRepository;
import com.bootcamp.technikon.repository.impl.PropertyOwnerRepositoryImpl;

public class TechnikonApplication {

	public static void main(String[] args) {

		PropertyOwnerRepositoryImpl owner = new PropertyOwnerRepositoryImpl();
		owner.addPropertyOwner("123456789", "Orfeas", "Marougkas", "+30-6983127341","marougkas@email.com", "user", "user123");
		owner.addPropertyOwner("987654321", "Kostas", "Mourikis", "+30-6921345671","mourikis@email.com", "mour", "mour123");
		owner.getPropertyOwners();
		//owner.updateProperyOwnerEmail("123456789", "orfeas@email.com");
		owner.safelyDeletePropertyOwner(1);
		owner.getPropertyOwners();

	}

}
