package alpha.study.CallAssistant.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alpha.study.CallAssistant.core.NumberInfo;

public class SilentExecutor extends Executor {
	private static final Logger logger = LoggerFactory.getLogger(SilentExecutor.class);

	@Override
	public boolean process(NumberInfo numberInfo) {
		// TODO
		logger.info("SilentExecutor processed phone number: {}", numberInfo.number);
		return true;
	}
}
