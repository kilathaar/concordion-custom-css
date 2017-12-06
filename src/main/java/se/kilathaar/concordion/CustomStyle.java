package se.kilathaar.concordion;

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.listener.*;

import java.util.Properties;

public class CustomStyle implements ConcordionExtension {
	private final Properties properties;

	public CustomStyle() {
		properties = new ReadPropertyFile("/custom-css.properties").properties();
	}

	@Override
	public void addTo(ConcordionExtender extender) {
		styleAssertTrueEvents(extender);
		styleAssertFalseEvents(extender);
		styleAssertEqualsEvents(extender);
		styleRunEvents(extender);
		extender.withLinkedCSS(fromProperty("css_file"), new Resource(fromProperty("css_file")));
		extender.withLinkedJavaScript(fromProperty("javascript_file"), new Resource(fromProperty("javascript_file")));
	}

	private void styleRunEvents(ConcordionExtender extender) {
		extender.withRunListener(new RunListener() {
			public void runStarted(RunStartedEvent event) {
				event.getElement().addStyleClass(fromProperty("run.started"));
			}

			public void successReported(RunSuccessEvent event) {
				event.getElement().addStyleClass(fromProperty("run.success"));
			}

			public void failureReported(RunFailureEvent event) {
				event.getElement().addStyleClass(fromProperty("run.failure"));
			}

			public void ignoredReported(RunIgnoreEvent runIgnoreEvent) {
				runIgnoreEvent.getElement().addStyleClass(fromProperty("run.ignore"));
			}

			public void throwableCaught(ThrowableCaughtEvent event) {
				event.getElement().addStyleClass(fromProperty("throwable.caught"));
			}
		});
	}

	private void styleAssertEqualsEvents(ConcordionExtender extender) {
		extender.withAssertEqualsListener(new AssertEqualsListener() {
			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_equals.success"));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_equals.failure"));
			}
		});
	}

	private void styleAssertFalseEvents(ConcordionExtender extender) {
		extender.withAssertFalseListener(new AssertFalseListener() {
			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_false.success"));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_false.failure"));
			}
		});
	}

	private void styleAssertTrueEvents(ConcordionExtender extender) {
		extender.withAssertTrueListener(new AssertTrueListener() {
			public void successReported(AssertSuccessEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_true.success"));
			}

			public void failureReported(AssertFailureEvent event) {
				event.getElement().addStyleClass(fromProperty("assert_true.failure"));
			}
		});
	}

	private String fromProperty(String key) {
		return properties.getProperty(key);
	}
}
