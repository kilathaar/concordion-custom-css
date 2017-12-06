package se.kilathaar.concordion;

import org.concordion.api.Element;

import java.util.Properties;

public class StyleCSS {
	final Properties properties;

	protected StyleCSS(Properties properties) {
		this.properties = properties;
	}

	void styleSuccess(Element element, String key) {
		element.addStyleClass(properties.getProperty(key + ".success"));
	}

	void styleFailure(Element element, String key) {
		element.addStyleClass(properties.getProperty(key + ".failure"));
	}
}
