package alpha.study.CallAssistant.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallAssistant {
	private static final Logger logger = LoggerFactory.getLogger(CallAssistant.class);         
	private List<Policy> policyList = null;

	public void setPolicy(List<Policy> policyList) {
		this.policyList = policyList;
	}

	public boolean addPolicy(Policy policy) {
		if (this.policyList == null) this.policyList = new LinkedList<>();
		return this.policyList.add(policy);
	}

	public List<Policy> getPolicy() {
		return this.policyList;
	}

	public boolean removePolicy(Policy policy) {
		if (this.policyList == null) return true;
		return this.policyList.remove(policy);
	}

	public void clearPolicy() {
		this.policyList.clear();
	}

	public boolean process(NumberInfo numberInfo) {
		if (this.policyList == null) {
			logger.info("NOT process phone number: {}", numberInfo.number);
			return false;			
		}

		Iterator<Policy> iterator = this.policyList.iterator();
		while (iterator.hasNext()) {
			Policy policy = iterator.next();
			if (policy.process(numberInfo)) {
				// log
				logger.info("assistant processed phone number: {}", numberInfo.number);
				return true;
			}
		}
		logger.info("NOT process phone number: {}", numberInfo.number);
		return false;
	}
}
