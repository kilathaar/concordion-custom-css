package se.kilathaar.concordion;

import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;

import java.util.Properties;

public class AssertEqualsStyle extends StyleCSS implements AssertEqualsListener {
	private static final String key = "assert_equals";

	AssertEqualsStyle(Properties properties) {
		super(properties);
	}

	@Override
	public void successReported(AssertSuccessEvent assertSuccessEvent) {
		styleSuccess(assertSuccessEvent.getElement(), key);
	}

	@Override
	public void failureReported(AssertFailureEvent assertFailureEvent) {
		styleFailure(assertFailureEvent.getElement(), key);
	}
}
