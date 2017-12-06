package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.api.listener.AssertTrueListener;

public class AssertTrueStyle extends StyleCSS implements AssertTrueListener {
	private static final String key = "assert_true";

	AssertTrueStyle(String filename) {
		super(filename);
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
