package se.kilathaar.concordion;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class CustomCSS implements ConcordionExtension {
	private final String filename = "/custom-css.properties";

	@SuppressWarnings("unused")
	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertTrueListener(new AssertTrueStyle(filename));
		concordionExtender.withAssertFalseListener(new AssertFalseStyle(filename));
		concordionExtender.withAssertEqualsListener(new AssertEqualsStyle(filename));
		concordionExtender.withRunListener(new RunStyle(filename));
	}
}
