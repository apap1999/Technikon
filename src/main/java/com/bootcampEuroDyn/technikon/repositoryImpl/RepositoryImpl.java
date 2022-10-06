package com.bootcampEuroDyn.technikon.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;


import com.bootcampEuroDyn.technikon.repository.Repository;

public abstract class RepositoryImpl<T,K> implements Repository<T,K>{
	
	protected EntityManager entityManager;
	
	public RepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Optional<T> add(T t) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
			return Optional.of(t);
		}catch (Exception e) {
			return Optional.empty();
		}
	}
	
	public abstract String getEntityClassName();
	public abstract Class<T> getEntityClass();
	

	@Override
	public List<T> read(int pageNumber, int pageSize) {
		String qString = "SELECT c FROM " + getEntityClassName() + " c WHERE c.id IS NOT NULL";
			 return entityManager
			.createQuery(qString)
			.getResultList();
		
	}

	@Override
	public Optional<T> read(K tId) {
		T t = entityManager
				.find(getEntityClass(), tId);
		return (t != null)? Optional.of(t) : Optional.empty();
	}

	@Override
	public boolean delete(K tId) {
		T persistentInstance = entityManager.find(getEntityClass(), tId);
		if(persistentInstance != null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(persistentInstance);
				entityManager.getTransaction().commit();
			}catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}
}
