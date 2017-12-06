package se.kilathaar.concordion;

import org.concordion.api.listener.AssertFailureEvent;
import org.concordion.api.listener.AssertFalseListener;
import org.concordion.api.listener.AssertSuccessEvent;

public class AssertFalseCSS implements AssertFalseListener {
	private final ReadPropertyFile read;

	AssertFalseCSS(String filename) {
		read = new ReadPropertyFile(filename);
	}

	@Override
	public void successReported(AssertSuccessEvent assertSuccessEvent) {
		assertSuccessEvent.getElement().addStyleClass(read.property("assert_false.success"));
	}

	@Override
	public void failureReported(AssertFailureEvent assertFailureEvent) {
		assertFailureEvent.getElement().addStyleClass(read.property("assert_false.failure"));
	}
}
