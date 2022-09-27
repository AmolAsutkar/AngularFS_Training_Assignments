package com.citiustech.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenericDao {

	protected static EntityManagerFactory entitymanagerfactory;

	static {
		entitymanagerfactory = Persistence.createEntityManagerFactory("hibernate-demo");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> entitymanagerfactory.close()));
	}

	public void save(Object obj) { // you cannot do this generic dao with jbbc, that is the beauty of ORM
		EntityManager entitymanager = null;
		try {
			entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction tx = entitymanager.getTransaction();
			tx.begin();
			entitymanager.merge(obj); // can be use for insert as well as update
			tx.commit(); // internally call flush
//entitymanager.flush(); // data not inserted as we have not commit

		} finally {
			entitymanager.close();
		}
	}

	public <E> E findById(Class<E> clazz, Object pk) {

		EntityManager entitymanager = null;
		try {
			entitymanager = entitymanagerfactory.createEntityManager();
			E e = entitymanager.find(clazz, pk); // find generates select query where primary key=?

			return e;
		} finally {
			entitymanager.close();
		}
	}
	}
