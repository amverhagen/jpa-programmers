package com.amverhagen.web.programmers.backend.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.amverhagen.web.programmers.backend.EntityManagerUtil;
import com.amverhagen.web.programmers.backend.entities.Color;

public class ColorServices {

	public static void saveColor(String name, String hexCode) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Color color = new Color();
		color.setName(name);
		color.setHexCode(hexCode);

		entityManager.persist(color);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static List<Color> getColors() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Color> colors = entityManager.createQuery("select c from Color c").getResultList();
			entityManager.getTransaction().commit();
			return colors;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

}
