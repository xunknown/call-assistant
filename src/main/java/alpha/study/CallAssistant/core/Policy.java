package alpha.study.CallAssistant.core;

import alpha.study.CallAssistant.criterion.CriteriaFilter;
import alpha.study.CallAssistant.executor.Executor;

public class Policy {
	private final int id;
	private String description;
	// 一致条件检查
	private CriteriaFilter complianceFilter = null;
	// 例外条件检查
	private CriteriaFilter exceptionFilter = null;
	// 执行动作
	private Executor executor = null;

	public Policy() {
		this.id = 0;
	}

	public Policy(int id) {
		this.id = id;
	}

	public Policy(int id, CriteriaFilter complianceFilter, CriteriaFilter exceptionFilter, Executor executor) {
		this.id = id;
		this.complianceFilter = complianceFilter;
		this.exceptionFilter = exceptionFilter;
		this.executor = executor;
	}

	public int id() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String description() {
		return this.description;
	}

	public void setComplianceFilter(CriteriaFilter complianceFilter) {
		this.complianceFilter = complianceFilter;
	}

	public CriteriaFilter getComplianceFilter() {
		return this.complianceFilter;
	}

	public void setExceptionFilter(CriteriaFilter exceptionFilter) {
		this.exceptionFilter = exceptionFilter;
	}

	public CriteriaFilter getExceptionFilter() {
		return this.exceptionFilter;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

	public Executor getExecutor() {
		return this.executor;
	}

	// 
	public boolean process(NumberInfo numberInfo) {
		if (this.complianceFilter != null && this.complianceFilter.filter(numberInfo.number)) {
			if (this.exceptionFilter != null && this.exceptionFilter.filter(numberInfo.number)) {
				return false;
			}
			return this.executor != null ? this.executor.process(numberInfo) : false;
		}
		return false;
	}
}
