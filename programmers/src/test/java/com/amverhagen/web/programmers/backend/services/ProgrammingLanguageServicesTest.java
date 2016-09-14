package com.amverhagen.web.programmers.backend.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.amverhagen.web.programmers.backend.entities.ProgrammingLanguage;

public class ProgrammingLanguageServicesTest {

	@Test
	public void ProgrammingLanguageCreationTest() {
		final String expectedLanguageName = "sas";
		ProgrammingLanguageServices.SaveProgrammingLanguage(expectedLanguageName);

		List<ProgrammingLanguage> addedLanguages = ProgrammingLanguageServices.getProgrammingLanguages();
		boolean addedExpectedLanguage = false;
		for (ProgrammingLanguage addedLanguage : addedLanguages) {
			if (addedLanguage.getName().equals(expectedLanguageName))
				addedExpectedLanguage = true;
		}

		Assert.assertTrue(addedExpectedLanguage);
	}
}
