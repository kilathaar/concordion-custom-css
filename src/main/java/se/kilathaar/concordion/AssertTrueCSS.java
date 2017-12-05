package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertSuccessEvent;
import org.concordion.api.listener.AssertTrueListener;

public class AssertTrueCSS implements AssertTrueListener {
	private final ReadPropertyFile read;

	AssertTrueCSS(String filename) {
		read = new ReadPropertyFile(filename);
	}

	@Override
	public void successReported(AssertSuccessEvent assertSuccessEvent) {
		assertSuccessEvent.getElement().addStyleClass(read.property("assert_true.success"));
	}

	@Override
	public void failureReported(AssertFailureEvent assertFailureEvent) {
		assertFailureEvent.getElement().addStyleClass(read.property("assert_true.failure"));
	}
}
