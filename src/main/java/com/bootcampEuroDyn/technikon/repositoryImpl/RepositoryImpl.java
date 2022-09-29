package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.List;

import com.bootcampEuroDyn.technikon.repository.Repository;

public class RepositoryImpl<T/*Extends Entity*/> implements Repository<T>{

	@Override
	public boolean add(T object) {
		// TODO Add object to database
		return false;
	}

	@Override
	public List<T> search(long id) {
		// TODO Search at the database with the given ID
		return null;
	}

	@Override
	public boolean update(long id) {
		// TODO Update the fields on the database for object with the given ID
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Safely delete from database the item with this ID
		return false;
	}

}
