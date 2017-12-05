package se.kilathaar.concordion;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

import java.io.IOException;
import java.util.Properties;

public class CustomCSS implements ConcordionExtension {
	private final Properties properties = new Properties();

	CustomCSS(String filename) throws IOException {
		if (filename == null) {
			throw new NullPointerException("Filename must not be null");
		}

		if (filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename must not be empty or whitespace");
		}
		properties.load(this.getClass().getResourceAsStream(filename));
	}

	@Override
	public void addTo(ConcordionExtender concordionExtender) {
	}

	Properties properties() {
		return properties;
	}
}
