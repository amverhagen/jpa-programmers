package com.amverhagen.web.programmers.backend.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.amverhagen.web.programmers.backend.EntityManagerUtil;
import com.amverhagen.web.programmers.backend.entities.ProgrammingLanguage;

public class ProgrammingLanguageServices {

	public static void SaveProgrammingLanguage(String languageName) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(languageName);

		entityManager.persist(programmingLanguage);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static List<ProgrammingLanguage> getProgrammingLanguages() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<ProgrammingLanguage> languages = entityManager.createQuery("select l from ProgrammingLanguage l")
					.getResultList();
			entityManager.getTransaction().commit();
			return languages;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	public static ProgrammingLanguage getProgrammingLanguageWithName(String name) {
		for (ProgrammingLanguage savedLanguage : ProgrammingLanguageServices.getProgrammingLanguages()) {
			if (savedLanguage.getName().equals(name))
				return savedLanguage;
		}
		return null;
	}
}
