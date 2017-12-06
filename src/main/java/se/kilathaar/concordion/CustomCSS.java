package se.kilathaar.concordion;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class CustomCSS implements ConcordionExtension {

	private final String filename = "/custom-css.properties";

	@SuppressWarnings("unused")
	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertTrueListener(new AssertTrueCSS(filename));
		concordionExtender.withAssertFalseListener(new AssertFalseCSS(filename));
		concordionExtender.withAssertEqualsListener(new AssertEqualsCSS(filename));
	}
}
