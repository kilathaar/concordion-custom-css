package se.kilathaar.concordion;

import org.concordion.api.Element;
import org.concordion.api.listener.*;

public class RunStyle extends StyleCSS implements RunListener {
	private static final String key = "run";

	RunStyle(String filename) {
		super(filename);
	}

	@Override
	public void runStarted(RunStartedEvent runStartedEvent) {
		runStartedEvent.getElement().addStyleClass(read.property(key + ".started"));
	}

	@Override
	public void successReported(RunSuccessEvent runSuccessEvent) {
		styleSuccess(runSuccessEvent.getElement(), key);
	}

	@Override
	public void failureReported(RunFailureEvent runFailureEvent) {
		styleFailure(runFailureEvent.getElement(), key);
	}

	@Override
	public void ignoredReported(RunIgnoreEvent runIgnoreEvent) {
		runIgnoreEvent.getElement().addStyleClass(read.property(key + ".ignore"));
	}

	@Override
	public void throwableCaught(ThrowableCaughtEvent throwableCaughtEvent) {
		Element element = throwableCaughtEvent.getElement();
		element.addStyleClass(read.property("throwable.caught"));
	}
}
