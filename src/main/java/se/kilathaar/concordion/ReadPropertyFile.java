package se.kilathaar.concordion;

import java.io.IOException;
import java.util.Properties;

class ReadPropertyFile {
	private final Properties properties = new Properties();

	ReadPropertyFile(String filename) throws IOException {
		if (filename == null) {
			throw new NullPointerException("Filename must not be null");
		}

		if (filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename must not be empty or whitespace");
		}
		properties.load(this.getClass().getResourceAsStream(filename));
	}

	Properties properties() {
		return properties;
	}

	String property(String key) {
		return properties.getProperty(key);
	}
}