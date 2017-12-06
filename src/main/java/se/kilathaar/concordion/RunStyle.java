package se.kilathaar.concordion;

import org.concordion.api.Element;
import org.concordion.api.listener.*;

import java.util.Properties;

public class RunStyle extends StyleCSS implements RunListener {
	private static final String key = "run";

	RunStyle(Properties properties) {
		super(properties);
	}

	@Override
	public void runStarted(RunStartedEvent runStartedEvent) {
		runStartedEvent.getElement().addStyleClass(properties.getProperty(key + ".started"));
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
		runIgnoreEvent.getElement().addStyleClass(properties.getProperty(key + ".ignore"));
	}

	@Override
	public void throwableCaught(ThrowableCaughtEvent throwableCaughtEvent) {
		Element element = throwableCaughtEvent.getElement();
		element.addStyleClass(properties.getProperty("throwable.caught"));
	}
}
