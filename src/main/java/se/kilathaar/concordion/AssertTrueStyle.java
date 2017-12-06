package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.api.listener.AssertTrueListener;

import java.util.Properties;

public class AssertTrueStyle extends StyleCSS implements AssertTrueListener {
	private static final String key = "assert_true";

	AssertTrueStyle(Properties properties) {
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
