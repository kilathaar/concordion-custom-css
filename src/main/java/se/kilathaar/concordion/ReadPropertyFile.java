package se.kilathaar.concordion;

import java.io.IOException;
import java.util.Properties;

class ReadPropertyFile {
	private final Properties properties = new Properties();

	ReadPropertyFile(String filename) {
		if (filename == null) {
			throw new NullPointerException("Filename must not be null");
		}

		if (filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename must not be empty or whitespace");
		}
		try {
			properties.load(this.getClass().getResourceAsStream(filename));
		} catch (IOException | NullPointerException e) {
			System.err.println("Failed to read file: " + filename);
		}
	}

	Properties properties() {
		return properties;
	}

	String property(String key) {
		return properties.getProperty(key);
	}
}