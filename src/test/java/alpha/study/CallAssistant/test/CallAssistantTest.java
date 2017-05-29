package alpha.study.CallAssistant.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alpha.study.CallAssistant.core.CallAssistant;
import alpha.study.CallAssistant.core.NumberInfo;
import alpha.study.CallAssistant.core.Policy;
import alpha.study.CallAssistant.criterion.BeginWithCriterion;
import alpha.study.CallAssistant.criterion.ContainCriterion;
import alpha.study.CallAssistant.criterion.CriteriaFilter;
import alpha.study.CallAssistant.criterion.EndWithCriterion;
import alpha.study.CallAssistant.criterion.ScopeCriterion;
import alpha.study.CallAssistant.executor.DefaultExecutor;
import alpha.study.CallAssistant.executor.Executor;

public class CallAssistantTest {
	private static final Logger logger = LoggerFactory.getLogger(CallAssistantTest.class);

	public static void main(String[] args) {
		logger.info("call assistant test ...");

		CriteriaFilter complianceFilter = new CriteriaFilter(1);
		ScopeCriterion criterion = new BeginWithCriterion(1, true);
		criterion.addSubject("0755");
		criterion.addSubject("0775");
		criterion.addSubject("010");
		criterion.addSubject("020");
		criterion.addSubject("13");
		complianceFilter.addCriterion(criterion);

		criterion = new ContainCriterion(2, true);
		criterion.addSubject("22");
		criterion.addSubject("33");
		complianceFilter.addCriterion(true, criterion);

		CriteriaFilter exceptionFilter = new CriteriaFilter(2);
		criterion = new EndWithCriterion(4, true);
		criterion.addSubject("3");
		criterion.addSubject("6");
		criterion.addSubject("9");
		exceptionFilter.addCriterion(criterion);

		Executor executor = new DefaultExecutor();
		executor.setConfig(new DefaultExecutor.DefaultExecutorConfig());

		Policy policy = new Policy(1, complianceFilter, exceptionFilter, executor);
		CallAssistant assistant = new CallAssistant();
		assistant.addPolicy(policy);

		// TEST
		String[] prefix = new String[] {"07", "075","0755", "1722","022", "010","020", "13", "33", "0775", "13533"};
		String[] suffix = new String[] {"076330", "07533","07922", "0743","022", "0106","026", "13", "0769", "0775",};
		NumberInfo numberInfo = new NumberInfo();
		for (int i = 0; i < 10; i++) {
			numberInfo.number = prefix[(int) (Math.random() * 1000) % prefix.length];
			numberInfo.number += (int) (Math.random() * 1000) % 2 == 0 ? prefix[(int) (Math.random() * 1000) % prefix.length] : suffix[(int) (Math.random() * 1000) % suffix.length];
			numberInfo.number += suffix[(int) (Math.random() * 1000) % suffix.length];
			numberInfo.callCount = (long) (Math.random() * 100);
			logger.info("incoming number: {}", numberInfo.number);
			assistant.process(numberInfo);
		}
	}
}
