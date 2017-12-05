package se.kilathaar.concordion;

import org.junit.Test;

import static org.junit.Assert.fail;

public class CustomCSSTest {
	@Test
	public void should_cast_NullPointerException_when_fileName_is_null() {
		try {
			new CustomCSS(null);
			fail("Did not throw expected exception");
		} catch (NullPointerException e) {
			// Nothing to do, expected exception was thrown
		}
	}

	@Test
	public void should_cast_IllegalArgumentException_when_fileName_is_empty() {
		try {
			new CustomCSS("");
			fail("Did not throw expected exception");
		} catch (IllegalArgumentException e) {
			// Nothing to do, expected exception was thrown
		}
	}

	@Test
	public void should_cast_IllegalArgumentException_when_fileName_is_whitespace() {
		try {
			new CustomCSS(" ");
			fail("Did not throw expected exception");
		} catch (IllegalArgumentException e) {
			// Nothing to do, expected exception was thrown
		}
	}
}
