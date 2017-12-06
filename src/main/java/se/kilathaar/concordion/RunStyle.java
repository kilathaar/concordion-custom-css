package se.kilathaar.concordion;

import org.concordion.api.Element;
import org.concordion.api.listener.*;

import java.util.Properties;

public class RunStyle implements RunListener {
	private static final String key = "run";
	private final Properties properties;

	RunStyle(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void runStarted(RunStartedEvent runStartedEvent) {
		runStartedEvent.getElement().addStyleClass(properties.getProperty(key + ".started"));
	}

	@Override
	public void successReported(RunSuccessEvent runSuccessEvent) {
		runSuccessEvent.getElement().addStyleClass(properties.getProperty(key + ".success"));
	}

	@Override
	public void failureReported(RunFailureEvent runFailureEvent) {
		runFailureEvent.getElement().addStyleClass(properties.getProperty(key + ".failure"));
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
