package com.bootcampEuroDyn.technikon.repository;

import java.util.List;
import java.util.Optional;


/**
 * Generic Interface containing Add Read Delete Functions
 *
 * @param <T> Class Type : model Classes (PropertyOwner,
 *            PropertyFunctionalities, PropertyRepair)
 * @param <K> Key Type : Long id
 */
public interface Repository<T, K> {
	
	Optional<T> add(T t);

	List<T> read(int pageNumber, int pageSize);

	Optional<T> read(K tId);

	boolean delete(K tId);
	

}
