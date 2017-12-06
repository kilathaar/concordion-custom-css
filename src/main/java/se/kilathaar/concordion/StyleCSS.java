package se.kilathaar.concordion;

import org.concordion.api.Element;

public class StyleCSS {
	final ReadPropertyFile read;

	protected StyleCSS(String filename) {
		read = new ReadPropertyFile(filename);
	}

	void styleSuccess(Element element, String key) {
		element.addStyleClass(read.property(key + ".success"));
	}

	void styleFailure(Element element, String key) {
		element.addStyleClass(read.property(key + ".failure"));
	}
}
