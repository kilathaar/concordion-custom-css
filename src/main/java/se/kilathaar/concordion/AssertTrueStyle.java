package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.api.listener.AssertTrueListener;

import java.util.Properties;

public class AssertTrueStyle implements AssertTrueListener {
	private final String key = "assert_true";
	private final Properties properties;

	AssertTrueStyle(Properties properties) {
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
