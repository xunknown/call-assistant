package alpha.study.CallAssistant.executor;

import alpha.study.CallAssistant.core.NumberInfo;

public abstract class Executor {
	transient Object config = null;
	public Executor() {
		
	}

	public void setConfig(Object config) {
		this.config = config;
	}

	public Object getConfig() {
		return this.config;
	}

	public abstract boolean process(NumberInfo numberInfo);
}
