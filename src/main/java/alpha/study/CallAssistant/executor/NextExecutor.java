package alpha.study.CallAssistant.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alpha.study.CallAssistant.core.NumberInfo;

public class NextExecutor extends Executor {
	private static final Logger logger = LoggerFactory.getLogger(NextExecutor.class);

	@Override
	public boolean process(NumberInfo numberInfo) {
		// ������false������������������������������������
		logger.info("NextExecutor processed phone number: {}", numberInfo.number);
		return false;
	}

}
