package com.amverhagen.web.programmers.backend.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.amverhagen.web.programmers.backend.EntityManagerUtil;
import com.amverhagen.web.programmers.backend.entities.Color;
import com.amverhagen.web.programmers.backend.entities.Programmer;
import com.amverhagen.web.programmers.backend.entities.ProgrammingLanguage;

public class ProgrammerServices {

	public static void saveProgrammer(String name, Color favoriteColor, ProgrammingLanguage favoriteLanguage,
			ProgrammingLanguage dislikedLangauge) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Programmer programmerToSave = new Programmer();
		programmerToSave.setName(name);
		programmerToSave.setFavoriteColor(favoriteColor);
		programmerToSave.setFavoriteProgrammingLanguage(favoriteLanguage);
		programmerToSave.setDislikedProgrammingLanguage(dislikedLangauge);

		entityManager.persist(programmerToSave);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static List<Programmer> getProgrammers() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Programmer> programmers = entityManager.createQuery("select p from Programmer p").getResultList();
			entityManager.getTransaction().commit();
			return programmers;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	public static Programmer getProgrammerWithName(String programmerName) {
		for (Programmer savedProgrammer : ProgrammerServices.getProgrammers()) {
			if (savedProgrammer.getFullName().equals(programmerName))
				return savedProgrammer;
		}
		return null;
	}
}
