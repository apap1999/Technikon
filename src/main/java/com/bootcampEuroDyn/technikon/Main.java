package com.bootcampEuroDyn.technikon;

import com.bootcampEuroDyn.technikon.repositoryImpl.PropertyOwnerRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		PropertyOwnerRepositoryImpl test = new PropertyOwnerRepositoryImpl();
		//vatNumber, firstName, surname, phoneNumber, email, username, passwords
		test.addPropertyOwner("123456789", "Orfeas", "Marougkas", "6981334563", "orfeas@email.com", "user", "pass");
		test.addPropertyOwner("987654321", "Andreas", "Papadias", "6945631821", "andreas@email.com", "root", "qwe");
		test.addPropertyOwner("567891234", "Aggelos", "Tsaousis", "6992738219", "aggelos@email.com", "admin", "1234");
		test.addPropertyOwner("012345678", "Dimitris", "Papadopoulos", "6955537213", "dimitris@email.com", "mitsos", "lol123");
		test.addPropertyOwner("537281937", "John", "Loulos", "6980029569", "john@email.com", "flower", "my_pass123");
		test.getPropertyOwners();
		test.safelyDeletePropertyOwner(5);
		test.safelyDeletePropertyOwner(4);
		test.getPropertyOwners();
	}

}
