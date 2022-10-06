package com.bootcampEuroDyn.technikon.repository;

import java.util.List;
import java.util.Optional;

import com.bootcampEuroDyn.technikon.domain.PropertyType;

public interface Repository <T,K> {
	
	Optional<T> add(T t);
	List<T> read(int pageNumber, int pageSize);
	Optional<T> read(K tId);
	boolean delete(K tId);
	

}
