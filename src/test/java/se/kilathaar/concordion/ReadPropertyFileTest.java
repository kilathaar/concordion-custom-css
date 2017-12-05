package se.kilathaar.concordion;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ReadPropertyFileTest {
	private ReadPropertyFile reader;

	@Test
	public void should_cast_NullPointerException_when_fileName_is_null() {
		try {
			new ReadPropertyFile(null);
			fail("Did not throw expected exception");
		} catch (NullPointerException e) {
			// Nothing to do, expected exception was thrown
		} catch (IOException e) {
			fail("Did not throw expected exception, caught IOException");
		}
	}

	@Test
	public void should_cast_IllegalArgumentException_when_fileName_is_empty() {
		try {
			new ReadPropertyFile("");
			fail("Did not throw expected exception");
		} catch (IllegalArgumentException e) {
			// Nothing to do, expected exception was thrown
		} catch (IOException e) {
			fail("Did not throw expected exception, caught IOException");
		}
	}

	@Test
	public void should_cast_IllegalArgumentException_when_fileName_is_whitespace() {
		try {
			new ReadPropertyFile(" ");
			fail("Did not throw expected exception");
		} catch (IllegalArgumentException e) {
			// Nothing to do, expected exception was thrown
		} catch (IOException e) {
			fail("Did not throw expected exception, caught IOException");
		}
	}

	@Before
	public void given_instance_of_ReadPropertyFile() throws IOException {
		reader = new ReadPropertyFile("/example.properties");
	}

	@Test
	public void should_find_property_assert_true_success() throws IOException {
		assertThat(reader.properties().getProperty("assert_true.success"), is("custom-success"));
	}

	@Test
	public void should_find_property_assert_true_failure() throws IOException {
		assertThat(reader.properties().getProperty("assert_true.failure"), is("custom-failure"));
	}
}
