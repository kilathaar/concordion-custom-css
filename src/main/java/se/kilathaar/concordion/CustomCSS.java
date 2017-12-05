package se.kilathaar.concordion;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class CustomCSS implements ConcordionExtension {
	CustomCSS(String filename) {
		if (filename == null) {
			throw new NullPointerException("Filename must not be null");
		}

		if (filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename must not be empty or whitespace");
		}
	}

	@Override
	public void addTo(ConcordionExtender concordionExtender) {
	}
}
