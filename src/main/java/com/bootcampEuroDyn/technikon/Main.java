package com.bootcampEuroDyn.technikon;



import javax.persistence.EntityManager;
import com.bootcampEuroDyn.technikon.UI.Data;
import com.bootcampEuroDyn.technikon.exceptions.IsValidPropertyOwner;

import com.bootcampEuroDyn.technikon.utility.JPAUtil;

public class Main {

	public static void main(String[] args) throws IsValidPropertyOwner {

		EntityManager entityManager = JPAUtil.getEntityManager();


		Data data = new Data();
		data.getData(entityManager);
		
		
		JPAUtil.shutdown();

	}

}