package com.amverhagen.web.programmers.backend.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.amverhagen.web.programmers.backend.entities.Color;

public class ColorServicesTest {

	@Test
	public void ColorCreationTest() {
		final String expectedName = "blue";
		final String expectedCode = "#0000FF";
		ColorServices.saveColor(expectedName, expectedCode);

		List<Color> addedColors = ColorServices.getColors();
		boolean addedExpectedColor = false;
		for (Color addedColor : addedColors) {
			if (addedColor.getName().equals(expectedName))
				if (addedColor.getHexCode().equals(expectedCode))
					addedExpectedColor = true;
		}

		Assert.assertTrue(addedExpectedColor);
	}

}
