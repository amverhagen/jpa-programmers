package com.amverhagen.web.programmers.backend.services;

import org.junit.Assert;
import org.junit.Test;

import com.amverhagen.web.programmers.backend.entities.Color;
import com.amverhagen.web.programmers.backend.entities.Programmer;
import com.amverhagen.web.programmers.backend.entities.ProgrammingLanguage;

public class ProgrammerServicesTest {

	@Test
	public void ProgrammerCreationTest() {
		final String expectedName = "Andrew Verhagen";
		final Color expectedColor = ColorServices.getColorWithName("blue");
		final ProgrammingLanguage expectedFavoriteLanguage = ProgrammingLanguageServices
				.getProgrammingLanguageWithName("java");
		final ProgrammingLanguage expectedDislikedLanguage = ProgrammingLanguageServices
				.getProgrammingLanguageWithName("sas");

		ProgrammerServices.saveProgrammer(expectedName, expectedColor, expectedFavoriteLanguage,
				expectedDislikedLanguage);

		final Programmer returnedProgrammer = ProgrammerServices.getProgrammerWithName(expectedName);
		if (returnedProgrammer != null) {
			Assert.assertEquals(expectedName, returnedProgrammer.getFullName());
			Assert.assertEquals(expectedColor.getName(), returnedProgrammer.getFavoriteColor().getName());
			Assert.assertEquals(expectedFavoriteLanguage.getName(),
					returnedProgrammer.getFavoriteProgrammingLangauge().getName());
			Assert.assertEquals(expectedDislikedLanguage.getName(),
					returnedProgrammer.getDislikedProgrammingLangauge().getName());
		} else
			Assert.fail("Programmer should not be null");
	}
}
