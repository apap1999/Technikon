package com.bootcampEuroDyn.technikon.repository;

import java.util.List;

public interface Repository <T> {
	
	boolean add(T object);
	List<T> search(long id);
	boolean update(long id);
	boolean delete(long id);

}
