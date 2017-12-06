package se.kilathaar.concordion;

import org.concordion.api.listener.AssertEqualsListener;
import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;

public class AssertEqualsCSS implements AssertEqualsListener {
	private final ReadPropertyFile read;

	AssertEqualsCSS(String filename) {
		read = new ReadPropertyFile(filename);
	}

	@Override
	public void successReported(AssertSuccessEvent assertSuccessEvent) {
		assertSuccessEvent.getElement().addStyleClass(read.property("assert_equals.success"));
	}

	@Override
	public void failureReported(AssertFailureEvent assertFailureEvent) {
		assertFailureEvent.getElement().addStyleClass(read.property("assert_equals.failure"));
	}
}
