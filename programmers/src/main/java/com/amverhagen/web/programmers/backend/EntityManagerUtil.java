package com.amverhagen.web.programmers.backend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final EntityManagerFactory entityManagerFactory;
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("programmers");
		} catch (Throwable ex) {
			System.out.println("Failed to create entity manager factory.");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		return EntityManagerUtil.entityManagerFactory.createEntityManager();
	}
}
