package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertFalseListener;
import org.concordion.api.listener.AssertSuccessEvent;

import java.util.Properties;

public class AssertFalseStyle implements AssertFalseListener {
	private final String key = "assert_false";
	private final Properties properties;

	AssertFalseStyle(Properties properties) {
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
