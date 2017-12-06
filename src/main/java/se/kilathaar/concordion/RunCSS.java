package se.kilathaar.concordion;

import org.concordion.api.Element;
import org.concordion.api.listener.*;

public class RunCSS implements RunListener {
	private final ReadPropertyFile read;

	RunCSS(String filename) {
		read = new ReadPropertyFile(filename);
	}

	@Override
	public void runStarted(RunStartedEvent runStartedEvent) {
		runStartedEvent.getElement().addStyleClass(read.property("run.started"));
	}

	@Override
	public void successReported(RunSuccessEvent runSuccessEvent) {
		runSuccessEvent.getElement().addStyleClass(read.property("run.success"));
	}

	@Override
	public void failureReported(RunFailureEvent runFailureEvent) {
		runFailureEvent.getElement().addStyleClass(read.property("run.failure"));
	}

	@Override
	public void ignoredReported(RunIgnoreEvent runIgnoreEvent) {
		runIgnoreEvent.getElement().addStyleClass(read.property("run.ignore"));
	}

	@Override
	public void throwableCaught(ThrowableCaughtEvent throwableCaughtEvent) {
		Element element = throwableCaughtEvent.getElement();
		element.addStyleClass(read.property("throwable.caught"));
	}
}
