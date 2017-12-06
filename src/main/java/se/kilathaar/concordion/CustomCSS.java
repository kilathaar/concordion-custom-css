package se.kilathaar.concordion;

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

import java.util.Properties;

public class CustomCSS implements ConcordionExtension {
	private final Properties properties;

	public CustomCSS() {
		properties = new ReadPropertyFile("/custom-css.properties").properties();
	}

	@SuppressWarnings("unused")
	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertTrueListener(new AssertTrueStyle(properties));
		concordionExtender.withAssertFalseListener(new AssertFalseStyle(properties));
		concordionExtender.withAssertEqualsListener(new AssertEqualsStyle(properties));
		concordionExtender.withRunListener(new RunStyle(properties));
		concordionExtender.withLinkedCSS(properties.getProperty("linked_css_file"), new Resource(properties.getProperty("linked_css_file")));
		concordionExtender.withLinkedJavaScript(properties.getProperty("linked_javascript_file"), new Resource(properties.getProperty("linked_javascript_file")));
	}
}
