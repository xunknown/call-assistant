package alpha.study.CallAssistant.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alpha.study.CallAssistant.core.NumberInfo;

public class DefaultExecutor extends Executor {
	static public class DefaultExecutorConfig {
		public int maxCallCount = 2;
	}
	private static final Logger logger = LoggerFactory.getLogger(DefaultExecutor.class);

	@Override
	public boolean process(NumberInfo numberInfo) {
		DefaultExecutorConfig defaultExecutorConfig = (DefaultExecutorConfig)this.config;
		// TODO
		logger.info("DefaultExecutor processed phone number: {}", numberInfo.number);
		return true;
	}
}
