package se.kilathaar.concordion;

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.listener.*;

import java.util.Properties;

public class CustomCSS implements ConcordionExtension {
	private final Properties properties;
	private final String success = ".success";
	private final String failure = ".failure";

	public CustomCSS() {
		properties = new ReadPropertyFile("/custom-css.properties").properties();
	}

	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		styleAssertTrueEvents(concordionExtender);
		styleAssertFalseEvents(concordionExtender);
		styleAssertEqualsEvents(concordionExtender);
		styleRunEvents(concordionExtender);
		concordionExtender.withLinkedCSS(properties.getProperty("linked_css_file"), new Resource(properties.getProperty("linked_css_file")));
		concordionExtender.withLinkedJavaScript(properties.getProperty("linked_javascript_file"), new Resource(properties.getProperty("linked_javascript_file")));
	}

	private void styleRunEvents(ConcordionExtender concordionExtender) {
		concordionExtender.withRunListener(new RunListener() {
			private static final String key = "run";

			public void runStarted(RunStartedEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + ".started"));
			}

			public void successReported(RunSuccessEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + success));
			}

			public void failureReported(RunFailureEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + failure));
			}

			public void ignoredReported(RunIgnoreEvent runIgnoreEvent) {
				runIgnoreEvent.getElement().addStyleClass(properties.getProperty(key + ".ignore"));
			}

			public void throwableCaught(ThrowableCaughtEvent event) {
				event.getElement().addStyleClass(properties.getProperty("throwable.caught"));
			}
		});
	}

	private void styleAssertEqualsEvents(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertEqualsListener(new AssertEqualsListener() {
			private final String key = "assert_equals";

			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + success));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + failure));
			}
		});
	}

	private void styleAssertFalseEvents(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertFalseListener(new AssertFalseListener() {
			private final String key = "assert_false";

			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + success));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + failure));
			}
		});
	}

	private void styleAssertTrueEvents(ConcordionExtender concordionExtender) {
		concordionExtender.withAssertTrueListener(new AssertTrueListener() {
			private final String key = "assert_true";

			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + success));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(properties.getProperty(key + failure));
			}
		});
	}
}
