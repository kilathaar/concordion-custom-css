package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertFalseListener;
import org.concordion.api.listener.AssertSuccessEvent;

public class AssertFalseStyle extends StyleCSS implements AssertFalseListener {
	private static final String key = "assert_false";

	AssertFalseStyle(String filename) {
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
