package se.kilathaar.concordion;

import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;

import java.util.Properties;

public class AssertEqualsStyle implements AssertEqualsListener {
	private final String key = "assert_equals";
	private final Properties properties;

	AssertEqualsStyle(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void successReported(AssertSuccessEvent assertSuccessEvent) {
		assertSuccessEvent.getElement().addStyleClass(properties.getProperty(key + ".success"));
	}

	@Override
	public void failureReported(AssertFailureEvent assertFailureEvent) {
		assertFailureEvent.getElement().addStyleClass(properties.getProperty(key + ".failure"));
	}
}
